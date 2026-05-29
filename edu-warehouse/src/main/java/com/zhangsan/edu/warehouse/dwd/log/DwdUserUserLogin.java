package com.zhangsan.edu.warehouse.dwd.log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhangsan.edu.warehouse.bean.DwdUserUserLoginBean;
import com.zhangsan.edu.warehouse.util.DateFormatUtil;
import com.zhangsan.edu.warehouse.util.EnvUtil;
import com.zhangsan.edu.warehouse.util.KafkaUtil;
import org.apache.flink.api.common.eventtime.SerializableTimestampAssigner;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.state.StateTtlConfig;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.common.time.Time;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.KeyedProcessFunction;
import org.apache.flink.util.Collector;

import java.time.Duration;


public class DwdUserUserLogin {
    public static void main(String[] args) throws Exception {
        //TODO 1 创建环境设置状态后端
        StreamExecutionEnvironment env = EnvUtil.getExecutionEnvironment(1);

        //TODO 2 读取kafka的dwd_traffic_page_log主题数据
        String topicName = "dwd_traffic_page_log";
        String groupId = "dwd_user_user_login";
        DataStreamSource<String> pageStream = env.fromSource(
                KafkaUtil.getKafkaConsumer(topicName, groupId),
                WatermarkStrategy.noWatermarks(),
                "user_login");

        pageStream.print("1-ppp ");
        //TODO 3 过滤及转换 uid != null
        SingleOutputStreamOperator<JSONObject> jsonObjStream = pageStream.flatMap(new FlatMapFunction<String, JSONObject>() {
            @Override
            public void flatMap(String value, Collector<JSONObject> out) throws Exception {
                try {
                    JSONObject jsonObject = JSON.parseObject(value);
                    if (jsonObject.getJSONObject("common").getString("uid") != null) {
                        out.collect(jsonObject);
                    }else {
                        System.out.println("无uid，剔除。");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        jsonObjStream.print("2-uuu ");
        //TODO 4 添加水印线
        SingleOutputStreamOperator<JSONObject> withWaterMarkStream = jsonObjStream.assignTimestampsAndWatermarks(
                WatermarkStrategy.<JSONObject>forBoundedOutOfOrderness(Duration.ofSeconds(5L)) // 延迟5秒
                        .withTimestampAssigner(new SerializableTimestampAssigner<JSONObject>() {
                            @Override
                            public long extractTimestamp(JSONObject element, long recordTimestamp) {
                                return element.getLong("ts");//日志中记录的业务发生时间
                            }
                        }));
        withWaterMarkStream.print("3-www ");
        //TODO 5 按照会话id分组
        KeyedStream<JSONObject, String> keyedStream = withWaterMarkStream.keyBy(new KeySelector<JSONObject, String>() {
            @Override
            public String getKey(JSONObject value) throws Exception {
                return value.getJSONObject("common").getString("sid");
            }
        });
        keyedStream.print("4-kkk ");
        //TODO 6 使用状态找出每个会话第一条数据
        SingleOutputStreamOperator<JSONObject> firstStream = keyedStream.process(new KeyedProcessFunction<String, JSONObject, JSONObject>() {
            ValueState<JSONObject> firstLoginDtState;

            @Override
            public void open(Configuration parameters) throws Exception {
                super.open(parameters);
                ValueStateDescriptor<JSONObject> valueStateDescriptor = new ValueStateDescriptor<>("first_login_dt", JSONObject.class);
                // 添加状态存活时间
                StateTtlConfig stateTtlConfig = StateTtlConfig
                        .newBuilder(Time.days(1L))
                        .setUpdateType(StateTtlConfig.UpdateType.OnCreateAndWrite)
                        .build();
                valueStateDescriptor.enableTimeToLive(stateTtlConfig);
                firstLoginDtState = getRuntimeContext().getState(valueStateDescriptor);
            }

            @Override
            public void processElement(JSONObject jsonObject, Context ctx, Collector<JSONObject> out) throws Exception {
                // 处理数据，获取状态
                JSONObject firstLoginDt = firstLoginDtState.value();
                Long ts = jsonObject.getLong("ts");
                if (firstLoginDt == null) {
                    out.collect(jsonObject);
                    firstLoginDtState.update(jsonObject);
                    // 第一条数据到的时候开启定时器
                    ctx.timerService().registerEventTimeTimer(ts + 10 * 1000L);
                } else {
                    Long lastTs = firstLoginDt.getLong("ts");
                    if (ts < lastTs) { //如果当前数据时间小于上次数据时间，则更新状态
                        firstLoginDtState.update(jsonObject);
                        JSONObject value = firstLoginDtState.value();
                        System.out.println("当前数据时间小于上次数据时间，使用最早的时间，该条数据不再发向下游\n"+value);
                    }else {
                        System.out.println("当前数据时间大于上次数据时间，该条数据不再发向下游\n" + jsonObject);
                    }
                }
            }

            @Override
            public void onTimer(long timestamp, OnTimerContext ctx, Collector<JSONObject> out) throws Exception {
                super.onTimer(timestamp, ctx, out);
//                out.collect(firstLoginDtState.value());
            }
        });
        firstStream.print("5-fff ");
        //TODO 7 转换结构
        SingleOutputStreamOperator<String> mapStream = firstStream.map(new MapFunction<JSONObject, String>() {
            @Override
            public String map(JSONObject jsonObj) throws Exception {
                JSONObject common = jsonObj.getJSONObject("common");
                Long ts = jsonObj.getLong("ts");
                String loginTime = DateFormatUtil.toYmdHms(ts);
                String dateId = loginTime.substring(0, 10);

                DwdUserUserLoginBean dwdUserUserLoginBean = DwdUserUserLoginBean.builder()
                        .userId(common.getString("uid"))
                        .dateId(dateId).loginTime(loginTime)
                        .channel(common.getString("ch"))
                        .provinceId(common.getString("ar"))
                        .versionCode(common.getString("vc"))
                        .midId(common.getString("mid"))
                        .brand(common.getString("ba"))
                        .model(common.getString("md"))
                        .sourceId(common.getString("sc"))
                        .operatingSystem(common.getString("os"))
                        .ts(ts)
                        .build();

                return JSON.toJSONString(dwdUserUserLoginBean);
            }
        });
        mapStream.print("6-mmm ");
        //TODO 8 输出数据
        String sinkTopic = "dwd_user_user_login";
        mapStream.sinkTo(KafkaUtil.getKafkaProducer(sinkTopic, "user_login_trans"));

        //TODO 9 执行任务
        env.execute();
    }
}
