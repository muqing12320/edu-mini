package com.zhangsan.edu.mock.service.impl;

import com.zhangsan.edu.mock.bean.OrderInfo;
import com.zhangsan.edu.mock.bean.UserInfo;
import com.zhangsan.edu.mock.config.AppConfig;
import com.zhangsan.edu.mock.mapper.UserInfoMapper;
import com.zhangsan.edu.mock.service.OrderInfoService;
import com.zhangsan.edu.mock.service.UserInfoService;
import com.zhangsan.edu.mock.service.adv.impl.AdvServiceImpl;
import com.zhangsan.edu.mock.util.RanOpt;
import com.zhangsan.edu.mock.util.RandomBox;
import com.zhangsan.edu.mock.util.RandomEmail;
import com.zhangsan.edu.mock.util.RandomName;
import com.zhangsan.edu.mock.util.RandomNum;
import com.zhangsan.edu.mock.util.RandomNumString;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.PostConstruct;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

@Service
@DependsOn("appConfig")
public class UserInfoServiceImpl extends AdvServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
   private static final Logger log = LoggerFactory.getLogger(UserInfoServiceImpl.class);
   @Autowired
   UserInfoMapper userInfoMapper;
   Set<Long> hasCourseUserSet;
   RandomBox<Boolean> ifStudyBox;
   @Autowired
   OrderInfoService orderInfoService;

   @PostConstruct
   protected void loadCache() {
      this.cache = new ConcurrentHashMap();
      this.resetUser();
      List<UserInfo> list = this.list((Wrapper)null);
      this.loadCache(list);
      this.initHasCourseUserSet();
      this.ifStudyBox = new RandomBox(AppConfig.if_study, 100 - AppConfig.if_study);
   }

   protected void resetUser() {
      boolean ifCleanUser = false;
      if (AppConfig.mock_clear_user.equals("1")) {
         ifCleanUser = true;
      }

      this.genUserInfos(ifCleanUser, AppConfig.mock_new_user, AppConfig.mock_date);
   }

   protected void initHasCourseUserSet() {
      List<OrderInfo> list = this.orderInfoService.list((Wrapper)(new QueryWrapper()).select(new String[]{"distinct user_id"}).eq("order_status", "1002"));
      this.hasCourseUserSet = new CopyOnWriteArraySet();

      for(OrderInfo orderInfo : list) {
         this.hasCourseUserSet.add(orderInfo.getUserId());
      }

   }

   public boolean checkifStudy(Long userId) {
      if (this.checkHasCourseByUserId(userId)) {
         log.debug("userID：" + userId + "有课程 可以学习 ");
         Boolean randBoolValue = this.ifStudyBox.getRandBoolValue();
         log.debug("userID：" + userId + " 是否坚持 学习 " + randBoolValue);
         return randBoolValue;
      } else {
         log.debug("userID：" + userId + "无课程 无法学习 ");
         return false;
      }
   }

   public boolean checkHasCourseByUserId(Long userId) {
      return this.hasCourseUserSet.contains(userId);
   }

   public void genUserInfos(Boolean ifClear, Integer newUser, Date busiDate) {
      List<UserInfo> userInfoList = new ArrayList();
      if (ifClear) {
         this.userInfoMapper.truncateUserInfo();
      } else {
         this.updateUsers(busiDate);
      }
      System.out.println("正在生成用户..."+newUser);
      for(int i = 0; i < newUser; ++i) {
         userInfoList.add(this.initUserInfo(busiDate));
      }

      if (userInfoList.size() > 0) {
         this.saveOrUpdateBatch(userInfoList, 1000, true);
         this.fixUserInfo(userInfoList);
         this.saveOrUpdateBatch(userInfoList, 1000, true);
      }

      log.warn("共生成{}名用户", userInfoList.size());
   }

   public UserInfo initUserInfo(Date date) {
      UserInfo userInfo = new UserInfo();
      String email = RandomEmail.getEmail(6, 12);
      String loginName = email.split("@")[0];
      userInfo.setLoginName(loginName);
      userInfo.setEmail(email);
      userInfo.setBirthday(DateUtils.addMonths(date, -1 * RandomNum.getRandInt(180, 660)));
      userInfo.setCreateTime(date);
      userInfo.setUserLevel((new RandomBox(new RanOpt[]{new RanOpt("1", 7), new RanOpt("2", 2), new RanOpt("3", 1)})).getRandStringValue());
      userInfo.setPhoneNum("13" + RandomNumString.getRandNumString(1, 9, 9, ""));
      return userInfo;
   }

   public void fixUserInfo(List<UserInfo> userInfoList) {
      for(UserInfo userInfo : userInfoList) {
         String gender = "";
         if (userInfo.getId() % 2L == 0L) {
            gender = "F";
         } else {
            gender = "M";
         }

         if (userInfo.getId() % 3L != 0L) {
            userInfo.setGender(gender);
         }

         String lastName = RandomName.insideLastName(gender);
         userInfo.setRealName(RandomName.getChineseFamilyName() + lastName);
         userInfo.setNickName(RandomName.getNickName(gender, lastName));
      }

   }

   public void updateUsers(Date date) {
      Integer updateRateWeight = AppConfig.mock_user_update_rate;
      int count = this.count((Wrapper)null);
      if (count != 0) {
         String userIds = RandomNumString.getRandNumString(1, count, count * updateRateWeight / 100, ",", false);
         List<UserInfo> userInfoList = this.list((Wrapper)(new QueryWrapper()).inSql("id", userIds));

         for(UserInfo userInfo : userInfoList) {
            int randInt = RandomNum.getRandInt(2, 7);
            String gender = "";
            if (userInfo.getId() % 2L == 0L) {
               gender = "F";
            } else {
               gender = "M";
            }

            if (randInt % 2 == 0) {
               String lastName = RandomName.insideLastName(gender);
               userInfo.setNickName(RandomName.getNickName(gender, lastName));
            }

            if (randInt % 3 == 0) {
               userInfo.setUserLevel((new RandomBox(new RanOpt[]{new RanOpt("1", 7), new RanOpt("2", 2), new RanOpt("3", 1)})).getRandStringValue());
            }

            if (randInt % 5 == 0) {
               String email = RandomEmail.getEmail(6, 12);
               userInfo.setEmail(email);
            }

            if (randInt % 7 == 0) {
               userInfo.setPhoneNum("13" + RandomNumString.getRandNumString(1, 9, 9, ""));
            }

            userInfo.setOperateTime(date);
         }

         log.warn("共有{}名用户发生变更", userInfoList.size());
         this.saveOrUpdateBatch(userInfoList, 1000, true);
      }
   }

   public void setUserHasCourse(Long userId) {
      this.hasCourseUserSet.add(userId);
   }

   public void clearUserHasCourse() {
      this.hasCourseUserSet.clear();
   }
}
