package com.zhangsan.edu.publish.service;

import com.zhangsan.edu.publish.bean.UserChangeCtPerType;

import java.util.List;

public interface UserStatsService {
    List<UserChangeCtPerType> getUserChangeCt(Integer date);
}
