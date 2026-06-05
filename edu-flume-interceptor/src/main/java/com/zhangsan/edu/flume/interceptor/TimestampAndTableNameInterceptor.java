package com.zhangsan.edu.flume.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class TimestampAndTableNameInterceptor implements Interceptor {
    @Override
    public void initialize() {

    }

    /*
    * 将body当中的ts， 放到header当中的 timestamp
    * 将body当中的table， 放到header当中的tableName
    * */
    @Override
    public Event intercept(Event event) {
        // 1 获取header 和body当中的数据
        Map<String, String> headers = event.getHeaders();
        byte[] body = event.getBody();
        String log = new String(body, StandardCharsets.UTF_8);

        // 2 解析body当中的  ts 和 table
        JSONObject jsonObject = JSONObject.parseObject(log);
        String table = jsonObject.getString("table");
        //Maxwell输出的数据中的ts字段时间戳单位为秒，Flume HDFSSink要求单位为毫秒
        String ts = jsonObject.getString("ts");

        // 将body当中的ts， 放到header当中的 timestamp
        // 将body当中的table， 放到header当中的tableName
        headers.put("tableName", table);
        headers.put("timestamp", ts + "000");

        return event;
    }

    @Override
    public List<Event> intercept(List<Event> list) {
        for (Event event : list) {
            intercept(event);
        }
        return list;
    }

    @Override
    public void close() {

    }

    public static class Builder implements Interceptor.Builder {

        @Override
        public Interceptor build() {
            return new TimestampAndTableNameInterceptor();
        }

        @Override
        public void configure(Context context) {

        }
    }
}
