package com.zhangsan.edu.warehouse.util;

import com.zhangsan.edu.warehouse.bean.DimTableProcess;
import com.zhangsan.edu.warehouse.common.EduConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class MySQLUtil {
    private static final Logger logger = LoggerFactory.getLogger(MySQLUtil.class);

    private static final String QUERY_TABLE_PROCESS_SQL = "SELECT source_table, sink_table, sink_columns, sink_pk, sink_extend FROM table_process";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Class.forName(EduConfig.MYSQL_DRIVER);
        connection = DriverManager.getConnection(
                EduConfig.MYSQL_URL,
                EduConfig.MYSQL_USERNAME,
                EduConfig.MYSQL_PASSWORD
        );
        return connection;
    }
    public static Map<String, DimTableProcess> getTableProcessMap() {
        Map<String, DimTableProcess> configMap = new HashMap<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(EduConfig.MYSQL_DRIVER);
            connection = DriverManager.getConnection(
                    EduConfig.MYSQL_URL,
                    EduConfig.MYSQL_USERNAME,
                    EduConfig.MYSQL_PASSWORD
            );

            preparedStatement = connection.prepareStatement(QUERY_TABLE_PROCESS_SQL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                DimTableProcess dimTableProcess = new DimTableProcess();
                dimTableProcess.setSourceTable(resultSet.getString("source_table"));
                dimTableProcess.setSinkTable(resultSet.getString("sink_table"));
                dimTableProcess.setSinkColumns(resultSet.getString("sink_columns"));
                dimTableProcess.setSinkPk(resultSet.getString("sink_pk"));
                dimTableProcess.setSinkExtend(resultSet.getString("sink_extend"));

                logger.info("初始化配置表数据：{} -> {}",
                        dimTableProcess.getSourceTable(),
                        dimTableProcess.getSinkTable());

                configMap.put(dimTableProcess.getSourceTable(), dimTableProcess);
            }
        } catch (ClassNotFoundException e) {
            logger.error("MySQL驱动加载失败", e);
            throw new RuntimeException("MySQL驱动加载失败", e);
        } catch (SQLException e) {
            logger.error("查询MySQL配置表失败", e);
            throw new RuntimeException("查询MySQL配置表失败", e);
        } finally {
            closeResources(resultSet, preparedStatement, connection);
        }

        return configMap;
    }

    private static void closeResources(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                logger.warn("关闭ResultSet失败", e);
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                logger.warn("关闭Statement失败", e);
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.warn("关闭Connection失败", e);
            }
        }
    }
}