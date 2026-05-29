package com.zhangsan.edu.warehouse.dwd.log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhangsan.edu.warehouse.util.EnvUtil;
import com.zhangsan.edu.warehouse.util.KafkaUtil;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.util.Collector;
import org.apache.flink.util.OutputTag;

public class BaseLogApp {
    public static void main(String[] args) throws Exception {
        // TODO 1. 环境准备及状态后端设置
        StreamExecutionEnvironment env = EnvUtil.getExecutionEnvironment(4);
        // TODO 2. 从 Kafka 读取主流数据
        String topic = "topic_log";
        String groupId = "base_log_app2";
        DataStreamSource<String> source = env.fromSource(KafkaUtil.getKafkaConsumer(topic, groupId),
                WatermarkStrategy.noWatermarks(), "base_log_source");

        // TODO 3. 数据清洗，转换结构
        // 3.1 定义错误侧输出流
        OutputTag<String> dirtyStreamTag = new OutputTag<String>("dirtyStream") {
        };
        // 3.2 分流（过滤脏数据），转换主流数据结构 jsonStr -> jsonObj
        SingleOutputStreamOperator<JSONObject> cleanedStream = source.process(
                new ProcessFunction<String, JSONObject>() {
                    @Override
                    public void processElement(String jsonStr, Context ctx, Collector<JSONObject> out) throws Exception {
                        try {
                            JSONObject jsonObj = JSON.parseObject(jsonStr);
                            out.collect(jsonObj); 				 // 主流
                        } catch (Exception e) {
                            ctx.output(dirtyStreamTag, jsonStr); // 侧输出
                        }
                    }
                }
        );

        // 3.3 将脏数据写出到 Kafka 指定主题
//        DataStream<String> dirtyStream = cleanedStream.getSideOutput(dirtyStreamTag);
//        String dirtyTopic = "dirty_data";
//        dirtyStream.sinkTo(KafkaUtil.getKafkaProducer(dirtyTopic, "dirty_trans"));

//        cleanedStream.print("cleaned");

        // TODO 5. 分流
        // 5.1 定义启动、曝光、动作、错误、播放侧输出流
        OutputTag<String> startTag = new OutputTag<String>("startTag") {
        };
        OutputTag<String> displayTag = new OutputTag<String>("displayTag") {
        };
        OutputTag<String> actionTag = new OutputTag<String>("actionTag") {
        };
        OutputTag<String> errorTag = new OutputTag<String>("errorTag") {
        };
        OutputTag<String> appVideoTag = new OutputTag<String>("appVideoTag") {
        };

// 5.2 分流
        SingleOutputStreamOperator<String> separatedStream = cleanedStream.process(
                new ProcessFunction<JSONObject, String>() {
                    @Override
                    public void processElement(JSONObject jsonObj, Context context, Collector<String> out) throws Exception {

                        // 5.2.1 收集错误数据
                        JSONObject error = jsonObj.getJSONObject("err");
                        if (error != null) {
                            context.output(errorTag, jsonObj.toJSONString());
                        }

                        // 剔除 "err" 字段
                        jsonObj.remove("err");

                        // 5.2.2 收集启动数据
                        JSONObject start = jsonObj.getJSONObject("start");
                        if (start != null) {
                            context.output(startTag, jsonObj.toJSONString());
                        } else {
                            // 获取 "common" 字段
                            JSONObject common = jsonObj.getJSONObject("common");
                            // 获取 "ts"
                            Long ts = jsonObj.getLong("ts");
                            JSONObject appVideo = jsonObj.getJSONObject("appVideo");

                            // 5.2.3 收集播放数据
                            if (appVideo != null) {
                                context.output(appVideoTag, jsonObj.toJSONString());
                            } else {

                                // 获取 "page" 字段
                                JSONObject page = jsonObj.getJSONObject("page");

                                // 5.2.4 收集曝光数据
                                JSONArray displays = jsonObj.getJSONArray("displays");
                                if (displays != null) {
                                    for (int i = 0; i < displays.size(); i++) {
                                        JSONObject display = displays.getJSONObject(i);
                                        JSONObject displayObj = new JSONObject();
                                        displayObj.put("display", display);
                                        displayObj.put("common", common);
                                        displayObj.put("page", page);
                                        displayObj.put("ts", ts);
                                        context.output(displayTag, displayObj.toJSONString());
                                    }
                                }

                                // 5.2.5 收集动作数据
                                JSONArray actions = jsonObj.getJSONArray("actions");
                                if (actions != null) {
                                    for (int i = 0; i < actions.size(); i++) {
                                        JSONObject action = actions.getJSONObject(i);
                                        JSONObject actionObj = new JSONObject();
                                        actionObj.put("action", action);
                                        actionObj.put("common", common);
                                        actionObj.put("page", page);
                                        context.output(actionTag, actionObj.toJSONString());
                                    }
                                }

                                // 5.2.6 收集页面数据
                                jsonObj.remove("displays");
                                jsonObj.remove("actions");
                                out.collect(jsonObj.toJSONString());
                            }
                        }

                    }
                }
        );
// 打印主流和各侧输出流查看分流效果
//        separatedStream.print("page>>>");
//        separatedStream.getSideOutput(startTag).print("start!!!");
//        separatedStream.getSideOutput(displayTag).print("display@@@");
//        separatedStream.getSideOutput(actionTag).print("action###");
//        separatedStream.getSideOutput(errorTag).print("error$$$");
//        separatedStream.getSideOutput(appVideoTag).print("appVideo$$$");

        // TODO 6. 将数据输出到 Kafka 的不同主题
// 6.1 提取各侧输出流
        DataStream<String> startDS = separatedStream.getSideOutput(startTag);
        DataStream<String> displayDS = separatedStream.getSideOutput(displayTag);
        DataStream<String> actionDS = separatedStream.getSideOutput(actionTag);
        DataStream<String> errorDS = separatedStream.getSideOutput(errorTag);
        DataStream<String> appVideoDS = separatedStream.getSideOutput(appVideoTag);

// 6.2 定义不同日志输出到 Kafka 的主题名称
        String page_topic = "dwd_traffic_page_log";
        String start_topic = "dwd_traffic_start_log";
        String display_topic = "dwd_traffic_display_log";
        String action_topic = "dwd_traffic_action_log";
        String error_topic = "dwd_traffic_error_log";
        String app_video_topic = "dwd_traffic_play_pre_process";

        separatedStream.sinkTo(KafkaUtil.getKafkaProducer(page_topic, "page_trans"));
        startDS.sinkTo(KafkaUtil.getKafkaProducer(start_topic, "start_trans"));
        displayDS.sinkTo(KafkaUtil.getKafkaProducer(display_topic, "display_trans"));
        actionDS.sinkTo(KafkaUtil.getKafkaProducer(action_topic, "action_trans"));
        errorDS.sinkTo(KafkaUtil.getKafkaProducer(error_topic, "error_trans"));
        appVideoDS.sinkTo(KafkaUtil.getKafkaProducer(app_video_topic, "app_video_trans"));

        env.execute();

    }
}
