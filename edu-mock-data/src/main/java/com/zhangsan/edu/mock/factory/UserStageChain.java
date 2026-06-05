package com.zhangsan.edu.mock.factory;

import com.zhangsan.edu.mock.bean.BaseProvince;
import com.zhangsan.edu.mock.bean.UserInfo;
import com.zhangsan.edu.mock.log.AppCommon;
import com.zhangsan.edu.mock.service.BaseProvinceService;
import com.zhangsan.edu.mock.service.OrderInfoService;
import com.zhangsan.edu.mock.service.UserInfoService;
import com.zhangsan.edu.mock.stage.Stage;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("userStageChain")
@Scope("prototype")
public class UserStageChain implements Runnable {
   @Autowired
   UserInfoService userInfoService;
   @Autowired
   BaseProvinceService baseProvinceService;
   @Autowired
   OrderInfoService orderInfoService;
   List<Stage> visitStages = new LinkedList();
   List<Stage> studyStages = new LinkedList();
   Date startDatetime;

   public UserStageChain addVisitStage(Stage stage) {
      this.visitStages.add(stage);
      return this;
   }

   public UserStageChain addStudyStage(Stage stage) {
      this.studyStages.add(stage);
      return this;
   }

   public void initAppCommonInfo() {
      AppCommon appCommon = AppCommon.build();
      UserInfo userInfo = UserSession.getUserInfo();
      Long id = userInfo.getId();
      BaseProvince baseProvince = (BaseProvince)this.baseProvinceService.getOneByRandom();
      appCommon.setAr(baseProvince.getId().toString());
      appCommon.setUid(id.toString());
      appCommon.setSid(UserSession.getSessionId());
      UserSession.setAppCommon(appCommon);
   }

   public void initSessionId() {
      String sessionId = UUID.randomUUID().toString();
      UserSession.setSessionId(sessionId);
   }

   public void initUserInfo() {
      UserInfo userInfo = (UserInfo)this.userInfoService.getOneByRandom();
      UserSession.setUserInfo(userInfo);
   }

   public void initTime() {
      UserSession.setCurDateTime(this.startDatetime);
   }

   public void run() {
      this.initSessionId();
      this.initUserInfo();
      this.initAppCommonInfo();
      this.initTime();
      if (this.checkifStudy()) {
         UserSession.setPurpose("STUDY");
         this.handleStages(this.studyStages);
      } else {
         UserSession.setPurpose("VISIT");
         this.handleStages(this.visitStages);
      }

   }

   private void handleStages(List<? extends Stage> stages) {
      for(int i = 0; i < stages.size(); ++i) {
         if (i < stages.size() - 1) {
            UserSession.setNextStageInfo(((Stage)stages.get(i + 1)).getClass());
         }

         boolean canContinue = ((Stage)stages.get(i)).handle();
         if (!canContinue) {
            break;
         }
      }

   }

   public boolean checkifStudy() {
      return this.userInfoService.checkifStudy(UserSession.getUserInfo().getId());
   }

   public UserInfoService getUserInfoService() {
      return this.userInfoService;
   }

   public BaseProvinceService getBaseProvinceService() {
      return this.baseProvinceService;
   }

   public OrderInfoService getOrderInfoService() {
      return this.orderInfoService;
   }

   public List<Stage> getVisitStages() {
      return this.visitStages;
   }

   public List<Stage> getStudyStages() {
      return this.studyStages;
   }

   public Date getStartDatetime() {
      return this.startDatetime;
   }

   public void setUserInfoService(final UserInfoService userInfoService) {
      this.userInfoService = userInfoService;
   }

   public void setBaseProvinceService(final BaseProvinceService baseProvinceService) {
      this.baseProvinceService = baseProvinceService;
   }

   public void setOrderInfoService(final OrderInfoService orderInfoService) {
      this.orderInfoService = orderInfoService;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof UserStageChain)) {
         return false;
      } else {
         UserStageChain other = (UserStageChain)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$userInfoService = this.getUserInfoService();
            Object other$userInfoService = other.getUserInfoService();
            if (this$userInfoService == null) {
               if (other$userInfoService != null) {
                  return false;
               }
            } else if (!this$userInfoService.equals(other$userInfoService)) {
               return false;
            }

            Object this$baseProvinceService = this.getBaseProvinceService();
            Object other$baseProvinceService = other.getBaseProvinceService();
            if (this$baseProvinceService == null) {
               if (other$baseProvinceService != null) {
                  return false;
               }
            } else if (!this$baseProvinceService.equals(other$baseProvinceService)) {
               return false;
            }

            Object this$orderInfoService = this.getOrderInfoService();
            Object other$orderInfoService = other.getOrderInfoService();
            if (this$orderInfoService == null) {
               if (other$orderInfoService != null) {
                  return false;
               }
            } else if (!this$orderInfoService.equals(other$orderInfoService)) {
               return false;
            }

            Object this$visitStages = this.getVisitStages();
            Object other$visitStages = other.getVisitStages();
            if (this$visitStages == null) {
               if (other$visitStages != null) {
                  return false;
               }
            } else if (!this$visitStages.equals(other$visitStages)) {
               return false;
            }

            Object this$studyStages = this.getStudyStages();
            Object other$studyStages = other.getStudyStages();
            if (this$studyStages == null) {
               if (other$studyStages != null) {
                  return false;
               }
            } else if (!this$studyStages.equals(other$studyStages)) {
               return false;
            }

            Object this$startDatetime = this.getStartDatetime();
            Object other$startDatetime = other.getStartDatetime();
            if (this$startDatetime == null) {
               if (other$startDatetime != null) {
                  return false;
               }
            } else if (!this$startDatetime.equals(other$startDatetime)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof UserStageChain;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $userInfoService = this.getUserInfoService();
      result = result * 59 + ($userInfoService == null ? 43 : $userInfoService.hashCode());
      Object $baseProvinceService = this.getBaseProvinceService();
      result = result * 59 + ($baseProvinceService == null ? 43 : $baseProvinceService.hashCode());
      Object $orderInfoService = this.getOrderInfoService();
      result = result * 59 + ($orderInfoService == null ? 43 : $orderInfoService.hashCode());
      Object $visitStages = this.getVisitStages();
      result = result * 59 + ($visitStages == null ? 43 : $visitStages.hashCode());
      Object $studyStages = this.getStudyStages();
      result = result * 59 + ($studyStages == null ? 43 : $studyStages.hashCode());
      Object $startDatetime = this.getStartDatetime();
      result = result * 59 + ($startDatetime == null ? 43 : $startDatetime.hashCode());
      return result;
   }

   public String toString() {
      return "UserStageChain(userInfoService=" + this.getUserInfoService() + ", baseProvinceService=" + this.getBaseProvinceService() + ", orderInfoService=" + this.getOrderInfoService() + ", visitStages=" + this.getVisitStages() + ", studyStages=" + this.getStudyStages() + ", startDatetime=" + this.getStartDatetime() + ")";
   }

   public void setVisitStages(final List<Stage> visitStages) {
      this.visitStages = visitStages;
   }

   public void setStudyStages(final List<Stage> studyStages) {
      this.studyStages = studyStages;
   }

   public void setStartDatetime(final Date startDatetime) {
      this.startDatetime = startDatetime;
   }
}
