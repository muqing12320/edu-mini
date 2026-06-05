package com.zhangsan.edu.mock.factory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhangsan.edu.mock.config.AppConfig;
import com.zhangsan.edu.mock.stage.Stage;
import com.zhangsan.edu.mock.util.ConfigUtil;
import com.zhangsan.edu.mock.util.RandomBox;
import com.zhangsan.edu.mock.util.RandomNum;
import com.google.common.base.CaseFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class UserStageChainFactory {
   Long userSessionCount;

   public List<UserStageChain> produce() {
      List<UserStageChain> userStageChainList = new LinkedList();
      String pathJson = ConfigUtil.loadJsonFile("path.json");
      JSONObject pathJSONObj = JSON.parseObject(pathJson);
      JSONArray visitPathJsonArr = pathJSONObj.getJSONArray("visit_path");
      JSONArray studyPathJsonArr = pathJSONObj.getJSONArray("study_path");
      RandomBox<List<String>> visitPathBox = this.getPathBox(visitPathJsonArr);
      RandomBox<List<String>> studyPathBox = this.getPathBox(studyPathJsonArr);
      RandomBox<Integer> hourBox = this.genHourBox();

      for(int i = 0; (long)i < this.userSessionCount; ++i) {
         UserStageChain userStageChain = (UserStageChain)ApplicationContextProvider.getBean("userStageChain", UserStageChain.class);
         List<Stage> visitStages = this.initStages(visitPathBox);
         List<Stage> studyStages = this.initStages(studyPathBox);
         userStageChain.setVisitStages(visitStages);
         userStageChain.setStudyStages(studyStages);
         Integer hour = hourBox.getRandIntValue();
         Date startDate = this.getDatetime(hour);
         userStageChain.setStartDatetime(startDate);
         userStageChainList.add(userStageChain);
      }

      return userStageChainList;
   }

   public List<Stage> initStages(RandomBox<List<String>> pathBox) {
      if (pathBox == null) {
         return null;
      } else {
         List<Stage> stages = new ArrayList();
         List<String> pathNameList = (List)pathBox.getValue();
         if (pathNameList != null) {
            for(String pathName : pathNameList) {
               Stage stage = this.getStageByPathName(pathName);
               stages.add(stage);
            }
         }

         return stages;
      }
   }

   private RandomBox<List<String>> getPathBox(JSONArray pathJsonArr) {
      RandomBox.Builder<List<String>> pathRanGroupBuilder = RandomBox.builder();

      for(int i = 0; i < pathJsonArr.size(); ++i) {
         JSONObject jsonObject = pathJsonArr.getJSONObject(i);
         List<String> path = jsonObject.getJSONArray("path").toJavaList(String.class);
         Integer rate = jsonObject.getInteger("rate");
         pathRanGroupBuilder.add(path, rate);
      }

      return pathRanGroupBuilder.build();
   }

   private Stage getStageByPathName(String pathName) {
      String beanName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, pathName);
      String className = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, pathName);
      Class clazz = null;

      try {
         clazz = Class.forName("com.studybigdata.mock.stage." + className + "Stage");
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
         throw new RuntimeException("com.studybigdata.mock.stage." + className + "Stage 未定义");
      }

      Stage stage = (Stage)ApplicationContextProvider.getBean(beanName, clazz);
      return stage;
   }

   private RandomBox<Integer> genHourBox() {
      Integer[] startTimeWeight = AppConfig.start_time_weight;
      RandomBox.Builder<Integer> hourRanBoxBuilder = RandomBox.builder();

      for(int hour = 0; hour < startTimeWeight.length; ++hour) {
         hourRanBoxBuilder.add(hour, startTimeWeight[hour]);
      }

      return hourRanBoxBuilder.build();
   }

   private Date getDatetime(Integer hour) {
      String mockDate = AppConfig.mock_date_str;
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      int minute = RandomNum.getRandInt(0, 59);
      int second = RandomNum.getRandInt(0, 59);
      String hourStr = StringUtils.leftPad(hour + "", 2, "0");
      String miniStr = StringUtils.leftPad(minute + "", 2, "0");
      String secStr = StringUtils.leftPad(second + "", 2, "0");
      String startTime = mockDate + " " + hourStr + ":" + miniStr + ":" + secStr;

      try {
         Date date = simpleDateFormat.parse(startTime);
         return date;
      } catch (ParseException e) {
         e.printStackTrace();
         throw new RuntimeException("日期生成错误！");
      }
   }

   UserStageChainFactory(final Long userSessionCount) {
      this.userSessionCount = userSessionCount;
   }

   public static UserStageChainFactoryBuilder builder() {
      return new UserStageChainFactoryBuilder();
   }

   private UserStageChainFactory() {
   }

   public Long getUserSessionCount() {
      return this.userSessionCount;
   }

   public void setUserSessionCount(final Long userSessionCount) {
      this.userSessionCount = userSessionCount;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof UserStageChainFactory)) {
         return false;
      } else {
         UserStageChainFactory other = (UserStageChainFactory)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$userSessionCount = this.getUserSessionCount();
            Object other$userSessionCount = other.getUserSessionCount();
            if (this$userSessionCount == null) {
               if (other$userSessionCount != null) {
                  return false;
               }
            } else if (!this$userSessionCount.equals(other$userSessionCount)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof UserStageChainFactory;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $userSessionCount = this.getUserSessionCount();
      result = result * 59 + ($userSessionCount == null ? 43 : $userSessionCount.hashCode());
      return result;
   }

   public String toString() {
      return "UserStageChainFactory(userSessionCount=" + this.getUserSessionCount() + ")";
   }

   public static class UserStageChainFactoryBuilder {
      private Long userSessionCount;

      UserStageChainFactoryBuilder() {
      }

      public UserStageChainFactoryBuilder userSessionCount(final Long userSessionCount) {
         this.userSessionCount = userSessionCount;
         return this;
      }

      public UserStageChainFactory build() {
         return new UserStageChainFactory(this.userSessionCount);
      }

      public String toString() {
         return "UserStageChainFactory.UserStageChainFactoryBuilder(userSessionCount=" + this.userSessionCount + ")";
      }
   }
}
