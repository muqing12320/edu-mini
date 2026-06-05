package com.zhangsan.edu.mock.stage;

import com.zhangsan.edu.mock.bean.CartInfo;
import com.zhangsan.edu.mock.bean.CourseInfo;
import com.zhangsan.edu.mock.bean.FavorInfo;
import com.zhangsan.edu.mock.config.AppConfig;
import com.zhangsan.edu.mock.factory.UserSession;
import com.zhangsan.edu.mock.log.AppAction;
import com.zhangsan.edu.mock.log.AppCommon;
import com.zhangsan.edu.mock.log.AppDisplay;
import com.zhangsan.edu.mock.log.AppMain;
import com.zhangsan.edu.mock.log.AppPage;
import com.zhangsan.edu.mock.log.enums.ActionId;
import com.zhangsan.edu.mock.log.enums.ItemType;
import com.zhangsan.edu.mock.log.enums.PageId;
import com.zhangsan.edu.mock.service.CartInfoService;
import com.zhangsan.edu.mock.service.CourseInfoService;
import com.zhangsan.edu.mock.service.FavorInfoService;
import com.zhangsan.edu.mock.service.OrderInfoService;
import com.zhangsan.edu.mock.service.ReviewInfoService;
import com.zhangsan.edu.mock.util.LogUtil;
import com.zhangsan.edu.mock.util.RandomBox;
import com.zhangsan.edu.mock.util.RandomCollection;
import com.zhangsan.edu.mock.util.RandomNum;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("courseDetail")
public class CourseDetailStage implements Stage {
   @Autowired
   OrderInfoService orderInfoService;
   @Autowired
   CourseInfoService courseInfoService;
   @Autowired
   CartInfoService cartInfoService;
   @Autowired
   FavorInfoService favorInfoService;
   @Autowired
   ReviewInfoService reviewInfoService;

   public boolean handle() {
      CourseInfo courseInfo = (CourseInfo)this.courseInfoService.getOneByRandom();
      AppMain appMain = this.mainLog(courseInfo);
      this.handleFavor(appMain, courseInfo);
      this.tryBuyCourse(appMain, courseInfo);
      LogUtil.logToJson(appMain);
      UserSession.setLastPageId(PageId.course_detail);
      UserSession.setCurCourseInfo(courseInfo);
      return true;
   }

   private CourseInfo getCourseInfoByPurpose() {
      List<CourseInfo> orderCourseList = this.orderInfoService.getOrderCourseList(UserSession.getUserInfo().getId());
      if (UserSession.getPurpose().equals("STUDY")) {
         return (CourseInfo)RandomCollection.getOneFrom(orderCourseList);
      } else {
         List<Long> existsCourseIdList = new ArrayList();

         for(CourseInfo courseInfo : orderCourseList) {
            existsCourseIdList.add(courseInfo.getId());
         }

         Map<Long, CourseInfo> courseInfoMap = this.courseInfoService.all(true);
         CourseInfo courseInfo = null;
         if (courseInfoMap.size() != 0) {
            courseInfo = (CourseInfo)RandomCollection.getOneFrom(courseInfoMap, existsCourseIdList);
         }

         return courseInfo;
      }
   }

   private AppMain mainLog(CourseInfo courseInfo) {
      AppCommon appCommon = UserSession.getAppCommon();
      Long courseId = courseInfo.getId();
      Integer durTime = RandomNum.getRandInt(5000, AppConfig.page_during_max_ms);
      AppPage appPage = AppPage.builder().last_page_id(UserSession.getLastPageId()).item(courseId.toString()).item_type(ItemType.course_id).during_time(durTime).page_id(PageId.course_detail).build();
      List<AppDisplay> appDisplayList = AppDisplay.buildList();
      UserSession.addTimeByDuringTime(durTime);
      AppMain appMain = AppMain.builder().common(appCommon).page(appPage).displays(appDisplayList).ts(UserSession.getCurDateTime().getTime()).checkError().build();
      return appMain;
   }

   private void tryBuyCourse(AppMain appMain, CourseInfo courseInfo) {
      for(CourseInfo orderCourse : this.orderInfoService.getOrderCourseList(UserSession.getUserInfo().getId())) {
         if (orderCourse.getId() == courseInfo.getId()) {
            return;
         }
      }

      if (UserSession.getNextStageInfo().equals(CartStage.class)) {
         List<CartInfo> cartList = UserSession.getCartList();
         if (cartList != null) {
            for(CartInfo cartInfo : cartList) {
               if (cartInfo.getCourseId() == courseInfo.getId()) {
                  return;
               }
            }
         }

         CartInfo cartInfo = this.genCart(courseInfo);
         AppAction cartAction = new AppAction(ActionId.cart_add, ItemType.course_id, cartInfo.getCourseId().toString(), UserSession.getCurDateTime().getTime());
         appMain.addAction(cartAction);
         this.cartInfoService.saveOrUpdate(cartInfo);
      } else if (UserSession.getNextStageInfo().equals(OrderStage.class)) {
         UserSession.setBuyingCourseInfo(courseInfo);
      }

   }

   private void handleCart(AppMain appMain, CourseInfo courseInfo) {
   }

   public CartInfo genCart(CourseInfo courseInfo) {
      CartInfo cartInfo = new CartInfo();
      cartInfo.setCourseName(courseInfo.getCourseName());
      cartInfo.setCourseId(courseInfo.getId());
      cartInfo.setCartPrice(courseInfo.getActualPrice());
      cartInfo.setUserId(UserSession.getUserInfo().getId());
      cartInfo.setCreateTime(UserSession.getCurDateTime());
      cartInfo.setSessionId(UserSession.getSessionId());
      cartInfo.setDeleted("0");
      cartInfo.setSold("0");
      UserSession.addCart(cartInfo);
      return cartInfo;
   }

   private void handleFavor(AppMain appMain, CourseInfo courseInfo) {
      Boolean ifFavor = RandomBox.builder().add(true, AppConfig.if_favor_rate).add(false, 100 - AppConfig.if_cart_rate).build().getRandBoolValue();
      if (ifFavor) {
         FavorInfo favorInfo = this.genFavor(courseInfo);
         this.favorInfoService.saveOrUpdate(favorInfo);
         AppAction favorAction = new AppAction(ActionId.favor_add, ItemType.course_id, favorInfo.getCourseId().toString(), UserSession.getCurDateTime().getTime());
         appMain.addAction(favorAction);
      }

   }

   public FavorInfo genFavor(CourseInfo courseInfo) {
      FavorInfo favorInfo = new FavorInfo();
      favorInfo.setCourseId(courseInfo.getId());
      favorInfo.setUserId(UserSession.getUserInfo().getId());
      favorInfo.setCreateTime(UserSession.getCurDateTime());
      favorInfo.setDeleted("0");
      return favorInfo;
   }
}
