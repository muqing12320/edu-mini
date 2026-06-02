package com.zhangsan.edu.publish.controller;

import com.zhangsan.edu.publish.bean.UserChangeCtPerType;
import com.zhangsan.edu.publish.service.UserStatsService;
import com.zhangsan.edu.publish.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/edu/realtime/user")
public class UserStatsController {
    @Autowired
    private UserStatsService userStatsService;

    @RequestMapping("/userChangeCt")
    public Map<String, Object> getUserChange(@RequestParam(value = "date", defaultValue = "1") Integer date) {
        if (date == 1) {
            date = DateUtil.now();
        }
        List<UserChangeCtPerType> userChangeCtList = userStatsService.getUserChangeCt(date);
        Map<String, Object> result = new HashMap<>();

        if (userChangeCtList == null || userChangeCtList.isEmpty()) {
            result.put("status", 0);
            result.put("msg", "");
            result.put("data", new HashMap<>());
            return result;
        }

        // 构建 columns
        List<Map<String, String>> columns = Arrays.asList(
                new HashMap<String, String>() {{
                    put("name", "变动类型");
                    put("id", "type");
                }},
                new HashMap<String, String>() {{
                    put("name", "用户数");
                    put("id", "user_ct");
                }}
        );
        // 构建 rows
        List<Map<String, Object>> rows = new java.util.ArrayList<>();
        for (UserChangeCtPerType userChangeCt : userChangeCtList) {
            Map<String, Object> row = new HashMap<>();
            row.put("type", userChangeCt.getType());
            row.put("user_ct", String.valueOf(userChangeCt.getUserCt()));
            rows.add(row);
        }

        Map<String, Object> data = new HashMap<>();
        data.put("columns", columns);
        data.put("rows", rows);

        result.put("status", 0);
        result.put("msg", "");
        result.put("data", data);
        System.out.println( result);
        return result;
    }

}