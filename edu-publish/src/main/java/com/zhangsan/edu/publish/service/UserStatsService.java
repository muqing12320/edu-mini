package com.zhangsan.edu.publish.service;

import com.zhangsan.edu.publish.bean.UserChangeCtPerType;
import com.zhangsan.edu.publish.bean.UserPageCt;
import com.zhangsan.edu.publish.bean.UserTradeCt;

import java.util.List;

public interface UserStatsService {
    List<UserChangeCtPerType> getUserChangeCt(Integer date);
    List<UserPageCt> getUvByPage(Integer date);
    List<UserTradeCt> getTradeUserCt(Integer date);
}
