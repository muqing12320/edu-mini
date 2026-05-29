package com.zhangsan.edu.warehouse.func;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhangsan.edu.warehouse.bean.DimTableProcess;
import com.zhangsan.edu.warehouse.util.MySQLUtil;
import com.zhangsan.edu.warehouse.util.PhoenixUtil;
import org.apache.flink.api.common.state.BroadcastState;
import org.apache.flink.api.common.state.MapStateDescriptor;
import org.apache.flink.api.common.state.ReadOnlyBroadcastState;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.co.BroadcastProcessFunction;
import org.apache.flink.util.Collector;

import java.util.*;

public class DimBroadcastFunction extends BroadcastProcessFunction<JSONObject, String, JSONObject>  {
    Map<String, DimTableProcess> configMap = new HashMap<>();

    private MapStateDescriptor<String, DimTableProcess> tableConfigDescriptor;

    public DimBroadcastFunction(MapStateDescriptor<String, DimTableProcess> tableConfigDescriptor) {
        this.tableConfigDescriptor = tableConfigDescriptor;
    }

    @Override
    public void open(Configuration parameters) throws Exception {
        configMap = MySQLUtil.getTableProcessMap();
    }

    @Override
    public void processElement(JSONObject jsonObj, ReadOnlyContext readOnlyContext, Collector<JSONObject> collector) throws Exception {
        ReadOnlyBroadcastState<String, DimTableProcess> dimTableProcessState = readOnlyContext.getBroadcastState(tableConfigDescriptor);
        // 获取配置信息
        String sourceTable = jsonObj.getString("table");
        DimTableProcess dimTableProcess = dimTableProcessState.get(sourceTable);

        // 如果状态中没有配置信息，从预加载 Map 中加载一次
        if (dimTableProcess == null) {
            dimTableProcess = configMap.get(sourceTable);
        }

        if (dimTableProcess != null) {
            // 判断操作类型是否为 null，校验数据结构是否完整
            String type = jsonObj.getString("type");
            if (type == null) {
                System.out.println("Maxwell 采集的数据格式异常，缺少操作类型");
            } else {
                JSONObject data = jsonObj.getJSONObject("data");

                String sinkTable = dimTableProcess.getSinkTable();
                String sinkColumns = dimTableProcess.getSinkColumns();

                // 根据 sinkColumns 过滤数据
                filterColumns(data, sinkColumns);

                // 将目标表名加入到主流数据中
                data.put("sink_table", sinkTable);

                collector.collect(data);
            }
        }
    }


    public void processBroadcastElement(String jsonStr, Context context, Collector<JSONObject> out) throws Exception {
        JSONObject jsonObj = JSON.parseObject(jsonStr);
        BroadcastState<String, DimTableProcess> tableConfigState = context.getBroadcastState(tableConfigDescriptor);
        String op = jsonObj.getString("op");
        if ("d".equals(op)) {
            DimTableProcess before = jsonObj.getObject("before", DimTableProcess.class);
            String sourceTable = before.getSourceTable();
            tableConfigState.remove(sourceTable);
            // 同时删除预加载 Map 中的配置信息
            configMap.remove(sourceTable);
        } else {
            DimTableProcess config = jsonObj.getObject("after", DimTableProcess.class);
            String sourceTable = config.getSourceTable();
            tableConfigState.put(sourceTable, config);
            String sinkTable = config.getSinkTable();
            String sinkColumns = config.getSinkColumns();
            String sinkPk = config.getSinkPk();
            String sinkExtend = config.getSinkExtend();

            PhoenixUtil.checkTable(sinkTable, sinkColumns, sinkPk, sinkExtend);
        }
    }

    private void filterColumns(JSONObject data, String sinkColumns) {
        Set<Map.Entry<String, Object>> entries = data.entrySet();
        List<String> stringList = Arrays.asList(sinkColumns.split(","));
        entries.removeIf(entry -> !stringList.contains(entry.getKey()));
    }
}
