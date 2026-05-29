package com.zhangsan.edu.warehouse.func;

import com.alibaba.fastjson.JSONObject;
import com.zhangsan.edu.warehouse.util.DimUtil;
import com.zhangsan.edu.warehouse.util.PhoenixUtil;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;


public class DimPhoenixSinkFunc implements SinkFunction<JSONObject> {
    @Override
    public void invoke(JSONObject jsonObject, Context context) throws Exception {
        // TODO 1 获取输出的表名
        String sinkTable = jsonObject.getString("sink_table");
        String type = jsonObject.getString("type");
        String id = jsonObject.getString("id");
        System.out.println("=== 维度数据输出：表名=" + sinkTable + ", 类型=" + type + ", ID=" + id);
        jsonObject.remove("sink_table");
        jsonObject.remove("type");

        // TODO 2 使用工具类 写出数据
        PhoenixUtil.executeDML(sinkTable, jsonObject);

        // TODO 3 如果类型为update 删除redis对应缓存
        if ("update".equals(type)){
            DimUtil.deleteCached(sinkTable,id);
        }
    }
}
