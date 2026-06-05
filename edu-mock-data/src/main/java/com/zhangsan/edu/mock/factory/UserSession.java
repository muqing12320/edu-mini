package com.zhangsan.edu.mock.factory;

import com.zhangsan.edu.mock.bean.CartInfo;
import com.zhangsan.edu.mock.bean.CourseInfo;
import com.zhangsan.edu.mock.bean.OrderInfo;
import com.zhangsan.edu.mock.bean.UserInfo;
import com.zhangsan.edu.mock.config.AppConfig;
import com.zhangsan.edu.mock.log.AppCommon;
import com.zhangsan.edu.mock.log.enums.PageId;
import com.zhangsan.edu.mock.stage.Stage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.time.DateUtils;

public class UserSession {
   public static final String PURPOSE_STUDY = "STUDY";
   public static final String PURPOSE_VISIT = "VISIT";
   private static ThreadLocal<UserInfo> userInfoThreadLocal = new ThreadLocal();
   private static ThreadLocal<Class<? extends Stage>> nextStageThreadLocal = new ThreadLocal();
   private static ThreadLocal<String> sessionIdThreadLocal = new ThreadLocal();
   private static ThreadLocal<Date> curDateTimeThreadLocal = new ThreadLocal();
   private static ThreadLocal<CourseInfo> curCourseThreadLocal = new ThreadLocal();
   private static ThreadLocal<CourseInfo> buyingCourseThreadLocal = new ThreadLocal();
   private static ThreadLocal<PageId> lastPageIdThreadLocal = new ThreadLocal();
   private static ThreadLocal<AppCommon> appCommonThreadLocal = new ThreadLocal();
   private static ThreadLocal<List<CartInfo>> cartListThreadLocal = new ThreadLocal();
   private static ThreadLocal<OrderInfo> orderInfoThreadLocal = new ThreadLocal();
   private static ThreadLocal<String> purposeThreadLocal = new ThreadLocal();

   public static String getPurpose() {
      return (String)purposeThreadLocal.get();
   }

   public static boolean isStudy() {
      return getPurpose().equals("STUDY");
   }

   public static void setPurpose(String purpose) {
      purposeThreadLocal.set(purpose);
   }

   public static UserInfo getUserInfo() {
      return (UserInfo)userInfoThreadLocal.get();
   }

   public static void setUserInfo(UserInfo userInfo) {
      userInfoThreadLocal.set(userInfo);
   }

   public static Class<? extends Stage> getNextStageInfo() {
      return (Class)nextStageThreadLocal.get();
   }

   public static void setNextStageInfo(Class<? extends Stage> stageClass) {
      nextStageThreadLocal.set(stageClass);
   }

   public static Date getCurDateTime() {
      return AppConfig.if_realtime == 1 ? new Date() : (Date)curDateTimeThreadLocal.get();
   }

   public static void setCurDateTime(Date dateTime) {
      curDateTimeThreadLocal.set(dateTime);
   }

   public static void addTimeByDuringTime(Integer duringTime) {
      Date date = DateUtils.addMilliseconds((Date)curDateTimeThreadLocal.get(), duringTime);
      curDateTimeThreadLocal.set(date);
   }

   public static CourseInfo getCurCourseInfo() {
      return (CourseInfo)curCourseThreadLocal.get();
   }

   public static void setCurCourseInfo(CourseInfo courseInfo) {
      curCourseThreadLocal.set(courseInfo);
   }

   public static CourseInfo getBuyingCourseInfo() {
      return (CourseInfo)buyingCourseThreadLocal.get();
   }

   public static void setBuyingCourseInfo(CourseInfo courseInfo) {
      buyingCourseThreadLocal.set(courseInfo);
   }

   public static PageId getLastPageId() {
      return (PageId)lastPageIdThreadLocal.get();
   }

   public static void setLastPageId(PageId pageId) {
      lastPageIdThreadLocal.set(pageId);
   }

   public static AppCommon getAppCommon() {
      return (AppCommon)appCommonThreadLocal.get();
   }

   public static void setAppCommon(AppCommon appCommon) {
      appCommonThreadLocal.set(appCommon);
   }

   public static String getSessionId() {
      return (String)sessionIdThreadLocal.get();
   }

   public static void setSessionId(String sessionId) {
      sessionIdThreadLocal.set(sessionId);
   }

   public static OrderInfo getOrderInfo() {
      return (OrderInfo)orderInfoThreadLocal.get();
   }

   public static void setOrderInfo(OrderInfo orderInfo) {
      orderInfoThreadLocal.set(orderInfo);
   }

   public static List<CartInfo> getCartList() {
      return (List)cartListThreadLocal.get();
   }

   public static void setCartList(List<CartInfo> cartList) {
      cartListThreadLocal.set(cartList);
   }

   public static void addCart(CartInfo cartInfo) {
      if (cartListThreadLocal.get() == null) {
         cartListThreadLocal.set(new ArrayList());
      }

      ((List)cartListThreadLocal.get()).add(cartInfo);
   }
}
