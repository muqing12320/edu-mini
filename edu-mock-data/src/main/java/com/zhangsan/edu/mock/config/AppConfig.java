package com.zhangsan.edu.mock.config;

import com.zhangsan.edu.mock.util.ParamUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
   public static Long user_session_count = 1000L;
   public static String mock_clear_user = "0";
   public static String mock_clear_busi = "0";
   public static String if_init_paper = "1";
   public static Integer mock_init_paper_max_q = 20;
   public static Integer mock_new_user = 0;
   public static Integer mock_user_update_rate = 15;
   public static String mock_date_str = "";
   public static Date mock_date = new Date();
   public static Integer mock_count = 1000;
   public static String mock_type = "log";
   public static String mock_url = "http://localhost:80";
   public static Integer max_mid = 500;
   public static Integer max_uid = 500;
   public static Integer max_coupon_id = 3;
   public static Integer max_course_id = 10;
   public static Integer page_during_max_ms = 20000;
   public static Integer error_rate = 30;
   public static Integer if_realtime = 0;
   public static Integer[] start_time_weight;
   public static Integer[] payment_type_weight;
   public static Integer video_heart_interval_sec = 30;
   public static Integer if_study = 50;
   public static Integer exam_corrent_rate = 50;
   public static Integer log_sleep = 100;
   public static Integer if_favor_rate = 30;
   public static Integer if_favor_cancel_rate = 10;
   public static Integer if_cart_rate = 10;
   public static Integer if_cart_add_num_rate = 10;
   public static Integer if_cart_minus_num_rate = 10;
   public static Integer if_cart_rm_rate = 10;
   public static Integer if_add_address = 15;
   public static Integer if_get_coupon = 25;
   public static Integer max_display_count = 10;
   public static Integer min_display_count = 4;
   public static Integer max_activity_count = 2;
   public static Integer max_pos_id = 5;
   public static Integer[] appraise_weight = new Integer[]{80, 10, 4, 1, 5};
   public static Integer[] sourceTypeRate;
   public static Integer[] vipThreshold = new Integer[]{50, 150, 500, 1000};
   public static String[] searchKeywords;
   public static String kafka_server;
   public static String kafka_topic;
   public static Integer[] skuWeightMale;
   public static Integer[] skuWeightFemale;

   @Value("${mock.start-time-weight}")
   public void setStartTimeWeight(String start_time_weight) {
      AppConfig.start_time_weight = ParamUtil.checkRate(start_time_weight, new int[0]);
   }

   @Value("${mock.if-init-paper}")
   public void setInitPaper(String if_init_paper) {
      AppConfig.if_init_paper = if_init_paper;
   }

   @Value("${mock.payment-type-weight}")
   public void setPaymentTypeWeight(String payment_type_weight) {
      AppConfig.payment_type_weight = ParamUtil.checkRate(payment_type_weight, new int[0]);
   }

   @Value("${mock.user-session.count}")
   public void setUserSessionCount(Long user_session_count) {
      AppConfig.user_session_count = user_session_count;
   }

   @Value("${mock.new.user}")
   public void setNewUser(String newUser) {
      System.out.println("=== 正在设置 mock_new_user，原始值: " + newUser + " ===");
      mock_new_user = ParamUtil.checkCount(newUser);
      System.out.println("=== 设置后 mock_new_user: " + mock_new_user + " ===");
   }

   @Value("${mock.if-realtime}")
   public void setIfRealtime(Integer ifRealtime) {
      if_realtime = ifRealtime;
   }

   @Value("${mock.clear.user}")
   public void setMockClearUser(String mockClearUser) {
      mock_clear_user = mockClearUser;
   }

   @Value("${mock.clear.busi}")
   public void setMockClearBusi(String mockClearBusi) {
      mock_clear_busi = mockClearBusi;
   }

   @Value("${mock.error.rate}")
   public void setError_rate(String error_rate) {
      AppConfig.error_rate = ParamUtil.checkRatioNum(error_rate);
   }

   @Value("${mock.date}")
   public void setMockDate(String mockDate) {
      mock_date_str = mockDate;
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

      try {
         mock_date = simpleDateFormat.parse(mockDate);
      } catch (ParseException e) {
         e.printStackTrace();
         throw new RuntimeException("日期格式不对！");
      }
   }

   @Value("${mock.search.keyword}")
   public void setSearchKeywords(String keywords) {
      searchKeywords = ParamUtil.checkArray(keywords);
   }
}
