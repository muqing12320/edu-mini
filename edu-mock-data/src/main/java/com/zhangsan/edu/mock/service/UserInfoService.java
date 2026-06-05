package com.zhangsan.edu.mock.service;

import com.zhangsan.edu.mock.bean.UserInfo;
import com.zhangsan.edu.mock.service.adv.AdvService;
import java.util.Date;

public interface UserInfoService extends AdvService<UserInfo> {
   void genUserInfos(Boolean ifClear, Integer newUser, Date busiDate);

   boolean checkHasCourseByUserId(Long userId);

   boolean checkifStudy(Long userId);

   void setUserHasCourse(Long userId);
}
