package com.zhangsan.edu.warehouse.common;

public class EduConfig {
    // kafka连接地址
    public static final String KAFKA_BOOTSTRAPS = "node1:9092,node2:9092,node3:9092";
    // mysql驱动
    public static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String MYSQL_URL = "jdbc:mysql://node1:3306/edu_config?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false";
    public static final String MYSQL_USERNAME = "root";
    public static final String MYSQL_PASSWORD = "123456";
    // Phoenix库名
    public static final String HBASE_SCHEMA = "EDU_REALTIME";
    // Phoenix驱动
    public static final String PHOENIX_DRIVER = "org.apache.phoenix.jdbc.PhoenixDriver";
    // Phoenix连接参数
    public static final String PHOENIX_SERVER = "jdbc:phoenix:node1,node2,node3:2181";
    // ClickHouse 驱动
    public static final String CLICKHOUSE_DRIVER = "ru.yandex.clickhouse.ClickHouseDriver";
    // ClickHouse 连接 URL
    public static final String CLICKHOUSE_URL = "jdbc:clickhouse://node1:8123/edu_realtime";

}
