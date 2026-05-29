package com.zhangsan.edu.warehouse.util;

import org.apache.flink.api.common.restartstrategy.RestartStrategies;
import org.apache.flink.api.common.time.Time;
import org.apache.flink.runtime.state.hashmap.HashMapStateBackend;
import org.apache.flink.streaming.api.CheckpointingMode;
import org.apache.flink.streaming.api.environment.CheckpointConfig;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;

public class EnvUtil {

    /**
     * 环境准备及状态后端设置
     * @param parallelism Flink 程序的并行度
     * @return Flink 流处理环境对象
     */
    public static StreamExecutionEnvironment getExecutionEnvironment(Integer parallelism) {
        // TODO 1. 环境准备
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(parallelism);

        // TODO 2. 状态后端设置
        env.enableCheckpointing(5000L, CheckpointingMode.EXACTLY_ONCE);
        env.getCheckpointConfig().setCheckpointTimeout(60 * 1000L);
        env.getCheckpointConfig().setMinPauseBetweenCheckpoints(3000L);
        env.getCheckpointConfig().setExternalizedCheckpointCleanup(
                CheckpointConfig.ExternalizedCheckpointCleanup.DELETE_ON_CANCELLATION
        );
        env.setRestartStrategy(RestartStrategies.failureRateRestart(
                3, Time.days(1), Time.minutes(1)
        ));
        env.setStateBackend(new HashMapStateBackend());
        env.getCheckpointConfig().setCheckpointStorage(
                "hdfs://node1:8020/edu/ck"
        );
        System.setProperty("HADOOP_USER_NAME", "zhangsan");
        return env;
    }

    public static void setTableEnvStateTtl(StreamTableEnvironment tableEnv, String ttl){
        tableEnv.getConfig().getConfiguration().setString("table.exec.state.ttl",ttl);
    }
}
