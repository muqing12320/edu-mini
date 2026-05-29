package com.zhangsan.edu.warehouse.dim;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ververica.cdc.connectors.mysql.source.MySqlSource;
import com.ververica.cdc.connectors.mysql.table.StartupOptions;
import com.ververica.cdc.debezium.JsonDebeziumDeserializationSchema;
import com.zhangsan.edu.warehouse.bean.DimTableProcess;
import com.zhangsan.edu.warehouse.func.DimBroadcastFunction;
import com.zhangsan.edu.warehouse.func.DimPhoenixSinkFunc;
import com.zhangsan.edu.warehouse.util.EnvUtil;
import com.zhangsan.edu.warehouse.util.KafkaUtil;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.state.MapStateDescriptor;
import org.apache.flink.streaming.api.datastream.BroadcastConnectedStream;
import org.apache.flink.streaming.api.datastream.BroadcastStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

public class DimSinkApp {

    public static void main(String[] args) throws Exception {
        // TODO 1. 环境准备及状态后端设置
        StreamExecutionEnvironment env = EnvUtil.getExecutionEnvironment(4);

        // TODO 2. 从Kafka中读取ods作为主流
        SingleOutputStreamOperator<JSONObject> jsonDS = read_ods_as_main_stream_from_kafka(env);

        // TODO 3 从MySQL中读取配置表数据
        DataStreamSource<String> mysqlDSSource = read_config_table_as_stream_with_cdc(env);

        // TODO 4 将配置表数据创建为广播流
        MapStateDescriptor<String, DimTableProcess> tableConfigDescriptor = new MapStateDescriptor<String, DimTableProcess>("table-process-state", String.class, DimTableProcess.class);
        BroadcastStream<String> broadcastDS = mysqlDSSource.broadcast(tableConfigDescriptor);

        // TODO 6 合并主流和广播流
        BroadcastConnectedStream<JSONObject, String> connectCS = jsonDS.connect(broadcastDS);

        // TODO 7 对合并流进行分别处理
        SingleOutputStreamOperator<JSONObject> dimDS = connectCS.process(new DimBroadcastFunction(tableConfigDescriptor));

        // TODO 8 调取维度数据写出到phoenix
        dimDS.addSink(new DimPhoenixSinkFunc());

        //3. 环境执行
        env.execute();
    }
    public static SingleOutputStreamOperator<JSONObject> read_ods_as_main_stream_from_kafka(StreamExecutionEnvironment env) throws Exception {
        // TODO 2. 读取业务主流
        String topic = "topic_db";
        String groupId = "dim_sink_ap";
        DataStreamSource<String> eduDS = env.fromSource(KafkaUtil.getKafkaConsumer(topic, groupId),
                WatermarkStrategy.noWatermarks(), "kafka_source");

        // TODO 3. 对主流数据进行ETL
        SingleOutputStreamOperator<JSONObject> jsonDS = eduDS.flatMap(new FlatMapFunction<String, JSONObject>() {
            @Override
            public void flatMap(String value, Collector<JSONObject> out) throws Exception {
                try {
                    JSONObject jsonObject = JSON.parseObject(value);
                    String type = jsonObject.getString("type");
                    if (!(type.equals("bootstrap-complete") || type.equals("bootstrap-start"))) {
                        // 需要的数据
                        out.collect(jsonObject);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("数据转换json错误");
                }
            }
        }) ;
        jsonDS.print();
        return jsonDS;
    }
    public static DataStreamSource<String> read_config_table_as_stream_with_cdc(StreamExecutionEnvironment env) throws Exception {
        // 1. FlinkCDC 读取配置表信息
        MySqlSource<String> mySqlSource = MySqlSource.<String>builder()
                .hostname("node1")
                .port(3306)
                .databaseList("edu_config") // set captured database
                .tableList("edu_config.table_process") // set captured table
                .username("root")
                .password("123456")
                .deserializer(new JsonDebeziumDeserializationSchema()) // converts SourceRecord to JSON String
                .startupOptions(StartupOptions.initial())//全量读取
                .build();
        System.out.println("=== 从 MySQL Source 创建数据流 ===");
        // 2. 封装为流
        DataStreamSource<String> mysqlDSSource = env.fromSource(mySqlSource, WatermarkStrategy.noWatermarks(), "MysqlSource");
        // 3. 打印cdc结果
        mysqlDSSource.print("mysql_cdc_data");

        return mysqlDSSource;
    }
}
