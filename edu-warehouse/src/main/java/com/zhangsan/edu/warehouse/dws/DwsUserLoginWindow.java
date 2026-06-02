package com.zhangsan.edu.warehouse.dws;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhangsan.edu.warehouse.bean.DwsUserLoginWindowBean;
import com.zhangsan.edu.warehouse.util.ClickHouseUtil;
import com.zhangsan.edu.warehouse.util.DateFormatUtil;
import com.zhangsan.edu.warehouse.util.EnvUtil;
import com.zhangsan.edu.warehouse.util.KafkaUtil;
import org.apache.flink.api.common.eventtime.SerializableTimestampAssigner;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.KeyedProcessFunction;
import org.apache.flink.streaming.api.functions.windowing.ProcessAllWindowFunction;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

import java.time.Duration;

public class DwsUserLoginWindow {
    public static void main(String[] args) throws Exception {
        // TODO 1 创建环境设置后端
        StreamExecutionEnvironment env = EnvUtil.getExecutionEnvironment(1);

        // TODO 2 读取dwd登录主题数据dwd_user_user_login
        String topicName = "dwd_user_user_login";
        String groupId = "dws_user_login_window";
        DataStreamSource<String> dwdLoginSourceStream = env.fromSource(KafkaUtil.getKafkaConsumer(topicName, groupId), WatermarkStrategy.noWatermarks(), "dwd_login_source");

        // TODO 3 按照user_id分组聚合
        KeyedStream<String, String> keyedStream = dwdLoginSourceStream.keyBy(new KeySelector<String, String>() {
            @Override
            public String getKey(String value) throws Exception {
                JSONObject jsonObject = JSON.parseObject(value);
                System.out.println("111-接入数据："+value);
                return jsonObject.getString("userId");
            }
        });

        // TODO 4 统计回流用户和独立用户数
        SingleOutputStreamOperator<DwsUserLoginWindowBean> processStream = keyedStream.process(new KeyedProcessFunction<String, String, DwsUserLoginWindowBean>() {
            ValueState<String> lastLoginDtState = null;

            @Override
            public void open(Configuration parameters) throws Exception {
                lastLoginDtState = getRuntimeContext().getState(new ValueStateDescriptor<String>("last_login_dt_state", String.class));
            }

            @Override
            public void processElement(String value, Context ctx, Collector<DwsUserLoginWindowBean> out) throws Exception {
                JSONObject jsonObject = JSON.parseObject(value);
                Long ts = jsonObject.getLong("ts");
                String curDate = DateFormatUtil.toDate(ts);
                String lastLoginDt = lastLoginDtState.value();
                long uvCount = 0L;
                long backCount = 0L;

                if (lastLoginDt == null) {
                    // 判断为独立  不判断为回流
                    uvCount = 1L;
                    lastLoginDtState.update(curDate);
                    System.out.println("独立用户数"+uvCount);
                } else {
                    if (lastLoginDt.compareTo(curDate) < 0) {
                        System.out.println("判断为回流用户数"+backCount);
                        // 一定是独立
                        uvCount = 1L;
                        if (ts - DateFormatUtil.toTs(lastLoginDt) > 1 * 24 * 3600 * 1000) {
                            backCount = 1L;
                        }
                        lastLoginDtState.update(curDate);
                    }
                }
                if (uvCount != 0L || backCount != 0L) {
                    System.out.println("回流用户数"+uvCount);
                    out.collect(DwsUserLoginWindowBean.builder()
                            .backCount(backCount)
                            .uvCount(uvCount)
                            .ts(ts)
                            .build());
                }
            }
        });

        // TODO 5 设置水位线
        SingleOutputStreamOperator<DwsUserLoginWindowBean> withWaterMarkStream = processStream.assignTimestampsAndWatermarks(WatermarkStrategy.<DwsUserLoginWindowBean>forBoundedOutOfOrderness(Duration.ofSeconds(5L)).withTimestampAssigner(new SerializableTimestampAssigner<DwsUserLoginWindowBean>() {
            @Override
            public long extractTimestamp(DwsUserLoginWindowBean element, long recordTimestamp) {
                return element.getTs();
            }
        }));

        // TODO 6 开窗聚合
        SingleOutputStreamOperator<DwsUserLoginWindowBean> reduceStream = withWaterMarkStream.windowAll(TumblingEventTimeWindows.of(Time.seconds(10L)))
                .reduce(new ReduceFunction<DwsUserLoginWindowBean>() {
                    @Override
                    public DwsUserLoginWindowBean reduce(DwsUserLoginWindowBean value1, DwsUserLoginWindowBean value2) throws Exception {
                        value1.setBackCount(value1.getBackCount() + value2.getBackCount());
                        value1.setUvCount(value1.getUvCount() + value2.getUvCount());
                        return value1;
                    }
                }, new ProcessAllWindowFunction<DwsUserLoginWindowBean, DwsUserLoginWindowBean, TimeWindow>() {
                    @Override
                    public void process(Context context, Iterable<DwsUserLoginWindowBean> elements, Collector<DwsUserLoginWindowBean> out) throws Exception {
                        String stt = DateFormatUtil.toYmdHms(context.window().getStart());
                        String edt = DateFormatUtil.toYmdHms(context.window().getEnd());
                        for (DwsUserLoginWindowBean element : elements) {
                            element.setStt(stt);
                            element.setEdt(edt);
                            element.setTs(System.currentTimeMillis());
                            out.collect(element);
                        }
                    }
                });

        // TODO 7 写出到clickHouse
        reduceStream.addSink(ClickHouseUtil.getJdbcSink("insert into dws_user_login_window values(?,?,?,?,?)"));

        // TODO 8 运行程序
        env.execute();

    }
}
