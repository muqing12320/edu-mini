package com.zhangsan.edu.mock.stage;

import com.zhangsan.edu.mock.bean.CartInfo;
import com.zhangsan.edu.mock.bean.CourseInfo;
import com.zhangsan.edu.mock.bean.OrderDetail;
import com.zhangsan.edu.mock.bean.OrderInfo;
import com.zhangsan.edu.mock.config.AppConfig;
import com.zhangsan.edu.mock.factory.UserSession;
import com.zhangsan.edu.mock.log.AppCommon;
import com.zhangsan.edu.mock.log.AppDisplay;
import com.zhangsan.edu.mock.log.AppMain;
import com.zhangsan.edu.mock.log.AppPage;
import com.zhangsan.edu.mock.log.enums.ItemType;
import com.zhangsan.edu.mock.log.enums.PageId;
import com.zhangsan.edu.mock.service.BaseProvinceService;
import com.zhangsan.edu.mock.service.CartInfoService;
import com.zhangsan.edu.mock.service.OrderDetailService;
import com.zhangsan.edu.mock.service.OrderInfoService;
import com.zhangsan.edu.mock.util.LogUtil;
import com.zhangsan.edu.mock.util.RandomNum;
import com.zhangsan.edu.mock.util.RandomNumString;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("order")
public class OrderStage implements Stage {
   @Autowired
   BaseProvinceService baseProvinceService;
   @Autowired
   OrderInfoService orderInfoService;
   @Autowired
   OrderDetailService orderDetailService;
   @Autowired
   CartInfoService cartInfoService;

   public boolean handle() {
      if ((UserSession.getLastPageId() != PageId.course_detail || UserSession.getBuyingCourseInfo() == null) && (UserSession.getCartList() == null || UserSession.getCartList().size() <= 0)) {
         System.out.println("该用户:" + UserSession.getUserInfo().getId() + "没有可下单的课程!");
         return false;
      } else {
         Integer durTime = RandomNum.getRandInt(5000, AppConfig.page_during_max_ms);
         UserSession.addTimeByDuringTime(durTime);
         OrderInfo orderInfo = this.genOrder();
         AppMain appMain = this.mainlog(orderInfo, durTime);
         LogUtil.logToJson(appMain);
         UserSession.setOrderInfo(orderInfo);
         UserSession.setLastPageId(PageId.order);
         return true;
      }
   }

   private AppMain mainlog(OrderInfo orderInfo, Integer durTime) {
      AppCommon appCommon = UserSession.getAppCommon();
      Long orderId = orderInfo.getId();
      AppPage appPage = AppPage.builder().last_page_id(UserSession.getLastPageId()).item(orderId.toString()).item_type(ItemType.order_id).during_time(durTime).page_id(PageId.order).build();
      List<AppDisplay> appDisplayList = AppDisplay.buildList();
      AppMain appMain = AppMain.builder().common(appCommon).page(appPage).displays(appDisplayList).ts(UserSession.getCurDateTime().getTime()).checkError().build();
      return appMain;
   }

   private OrderInfo genOrder() {
      List<CartInfo> cartList = UserSession.getCartList();
      List<OrderDetail> orderDetailList = new ArrayList();
      if (UserSession.getLastPageId() == PageId.course_detail && UserSession.getBuyingCourseInfo() != null) {
         CourseInfo courseInfo = UserSession.getBuyingCourseInfo();
         orderDetailList.add(this.genOrderDetailFromCourse(courseInfo));
      } else if (UserSession.getLastPageId() == PageId.cart && cartList.size() > 0) {
         boolean ifRepeat = false;

         for(CartInfo cartInfo : cartList) {
            for(OrderDetail orderDetail : orderDetailList) {
               if (orderDetail.getCourseId() == cartInfo.getCourseId()) {
                  ifRepeat = true;
               }
            }

            if (!ifRepeat) {
               orderDetailList.add(this.genOrderDetailFromCart(cartInfo));
               cartInfo.setSold("1");
               cartInfo.setUpdateTime(UserSession.getCurDateTime());
            }
         }

         this.cartInfoService.saveOrUpdateBatch(cartList, 10);
      }

      OrderInfo orderInfo = this.genOrderInfo(orderDetailList);
      this.orderInfoService.saveOrUpdate(orderInfo);

      for(OrderDetail orderDetail : orderDetailList) {
         orderDetail.setOrderId(orderInfo.getId());
      }

      this.orderDetailService.saveOrUpdateBatch(orderDetailList, 10);
      return orderInfo;
   }

   private OrderInfo genOrderInfo(List<OrderDetail> orderDetailList) {
      OrderInfo orderInfo = new OrderInfo();
      orderInfo.setOrderDetailList(orderDetailList);
      String tradeInfo = orderInfo.getTradeInfo();
      orderInfo.setUserId(UserSession.getUserInfo().getId());
      orderInfo.setTradeBody(tradeInfo);
      orderInfo.setCreateTime(UserSession.getCurDateTime());
      orderInfo.setExpireTime(DateUtils.addMinutes(UserSession.getCurDateTime(), 15));
      orderInfo.setOrderStatus("1001");
      orderInfo.setOutTradeNo(RandomNumString.getRandNumString(1, 9, 15, ""));
      orderInfo.setProvinceId(Long.parseLong(UserSession.getAppCommon().getAr()));
      BigDecimal sumCouponReduce = BigDecimal.ZERO;
      BigDecimal sumOriginAmount = BigDecimal.ZERO;
      BigDecimal sumFinalAmount = BigDecimal.ZERO;

      for(OrderDetail orderDetail : orderDetailList) {
         sumCouponReduce = sumCouponReduce.add(orderDetail.getCouponReduce());
         sumOriginAmount = sumOriginAmount.add(orderDetail.getOriginAmount());
         sumFinalAmount = sumFinalAmount.add(orderDetail.getFinalAmount());
      }

      orderInfo.setOriginAmount(sumOriginAmount);
      orderInfo.setCouponReduce(sumCouponReduce);
      orderInfo.setFinalAmount(sumFinalAmount);
      orderInfo.setSessionId(UserSession.getSessionId());
      return orderInfo;
   }

   private OrderDetail genOrderDetailFromCart(CartInfo cartInfo) {
      OrderDetail orderDetail = new OrderDetail();
      orderDetail.setCourseId(cartInfo.getCourseId());
      orderDetail.setCourseName(cartInfo.getCourseName());
      orderDetail.setOriginAmount(cartInfo.getCartPrice());
      orderDetail.setCouponReduce(BigDecimal.ZERO);
      orderDetail.setFinalAmount(orderDetail.getOriginAmount().subtract(orderDetail.getCouponReduce()));
      orderDetail.setUserId(UserSession.getUserInfo().getId());
      orderDetail.setCreateTime(UserSession.getCurDateTime());
      return orderDetail;
   }

   private OrderDetail genOrderDetailFromCourse(CourseInfo courseInfo) {
      OrderDetail orderDetail = new OrderDetail();
      orderDetail.setCourseId(courseInfo.getId());
      orderDetail.setCourseName(courseInfo.getCourseName());
      orderDetail.setOriginAmount(courseInfo.getActualPrice());
      orderDetail.setCouponReduce(BigDecimal.ZERO);
      orderDetail.setFinalAmount(orderDetail.getOriginAmount().subtract(orderDetail.getCouponReduce()));
      orderDetail.setUserId(UserSession.getUserInfo().getId());
      orderDetail.setCreateTime(UserSession.getCurDateTime());
      return orderDetail;
   }
}
