package com.zhangsan.edu.mock.stage;

import com.zhangsan.edu.mock.bean.OrderInfo;
import com.zhangsan.edu.mock.bean.PaymentInfo;
import com.zhangsan.edu.mock.bean.VipChangeDetail;
import com.zhangsan.edu.mock.config.AppConfig;
import com.zhangsan.edu.mock.factory.UserSession;
import com.zhangsan.edu.mock.log.AppCommon;
import com.zhangsan.edu.mock.log.AppDisplay;
import com.zhangsan.edu.mock.log.AppMain;
import com.zhangsan.edu.mock.log.AppPage;
import com.zhangsan.edu.mock.log.enums.ItemType;
import com.zhangsan.edu.mock.log.enums.PageId;
import com.zhangsan.edu.mock.service.OrderInfoService;
import com.zhangsan.edu.mock.service.PaymentInfoService;
import com.zhangsan.edu.mock.service.UserInfoService;
import com.zhangsan.edu.mock.service.VipChangeDetailService;
import com.zhangsan.edu.mock.util.LogUtil;
import com.zhangsan.edu.mock.util.RanOpt;
import com.zhangsan.edu.mock.util.RandomBox;
import com.zhangsan.edu.mock.util.RandomNum;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("payment")
public class PaymentStage implements Stage {
   @Autowired
   PaymentInfoService paymentInfoService;
   @Autowired
   OrderInfoService orderInfoService;
   @Autowired
   UserInfoService userInfoService;
   @Autowired
   VipChangeDetailService vipChangeDetailService;

   public boolean handle() {
      if (UserSession.getOrderInfo() == null) {
         return false;
      } else {
         AppMain mainlog = this.mainlog();
         LogUtil.logToJson(mainlog);
         PaymentInfo paymentInfo = this.genPaymentInfo();
         this.paymentInfoService.saveOrUpdate(paymentInfo);
         this.updateOrderInfo();
         UserSession.setLastPageId(PageId.payment);
         return true;
      }
   }

   private AppMain mainlog() {
      AppCommon appCommon = UserSession.getAppCommon();
      Long orderId = UserSession.getOrderInfo().getId();
      Integer durTime = RandomNum.getRandInt(5000, AppConfig.page_during_max_ms);
      AppPage appPage = AppPage.builder().last_page_id(UserSession.getLastPageId()).item(orderId.toString()).item_type(ItemType.order_id).during_time(durTime).page_id(PageId.payment).build();
      List<AppDisplay> appDisplayList = AppDisplay.buildList();
      UserSession.addTimeByDuringTime(appPage.getDuring_time());
      Long ts = UserSession.getCurDateTime().getTime();
      AppMain appMain = AppMain.builder().common(appCommon).page(appPage).displays(appDisplayList).ts(ts).build();
      return appMain;
   }

   private PaymentInfo genPaymentInfo() {
      OrderInfo orderInfo = UserSession.getOrderInfo();
      PaymentInfo paymentInfo = new PaymentInfo();
      paymentInfo.setOrderId(orderInfo.getId());
      paymentInfo.setTradeBody(orderInfo.getTradeBody());
      paymentInfo.setAlipayTradeNo(UUID.randomUUID().toString());
      RandomBox<String> paymentTypeBox = new RandomBox(new RanOpt[]{new RanOpt("1101", AppConfig.payment_type_weight[0]), new RanOpt("1102", AppConfig.payment_type_weight[1]), new RanOpt("1103", AppConfig.payment_type_weight[2])});
      String paymentType = paymentTypeBox.getRandStringValue();
      paymentInfo.setPaymentType(paymentType);
      paymentInfo.setPaymentStatus("1602");
      paymentInfo.setCreateTime(UserSession.getCurDateTime());
      paymentInfo.setCallbackTime(DateUtils.addSeconds(UserSession.getCurDateTime(), 10));
      paymentInfo.setOutTradeNo(orderInfo.getOutTradeNo());
      paymentInfo.setTotalAmount(orderInfo.getFinalAmount());
      return paymentInfo;
   }

   private void updateOrderInfo() {
      OrderInfo orderInfo = UserSession.getOrderInfo();
      orderInfo.setOrderStatus("1002");
      orderInfo.setUpdateTime(UserSession.getCurDateTime());
      this.orderInfoService.saveOrUpdate(orderInfo);
      this.userInfoService.setUserHasCourse(orderInfo.getUserId());
      this.vipChange(orderInfo);
   }

   private void vipChange(OrderInfo orderInfo) {
      Integer[] vipThresholds = AppConfig.vipThreshold;
      OrderInfo sumOrder = (OrderInfo)this.orderInfoService.getOne((Wrapper)((QueryWrapper)(new QueryWrapper()).select(new String[]{" sum(final_amount) final_amount"}).eq("user_id", orderInfo.getUserId())).eq("order_status", "1002"));
      BigDecimal sumAmount = sumOrder.getFinalAmount();
      int toVip = 0;

      for(int i = 0; i < vipThresholds.length; ++i) {
         Integer threshold = vipThresholds[i];
         if (sumAmount.compareTo(BigDecimal.valueOf((long)threshold)) > 0) {
            toVip = i + 1;
         }
      }

      Integer fromVip = 0;
      VipChangeDetail existsVipChangeDetail = (VipChangeDetail)this.vipChangeDetailService.getOne((Wrapper)((QueryWrapper)((QueryWrapper)(new QueryWrapper()).eq("user_id", orderInfo.getUserId())).orderByDesc("create_time")).last(" limit 1"));
      if (existsVipChangeDetail != null) {
         fromVip = existsVipChangeDetail.getToVip();
      }

      VipChangeDetail vipChangeDetail = new VipChangeDetail();
      vipChangeDetail.setFromVip(fromVip);
      vipChangeDetail.setToVip(toVip);
      vipChangeDetail.setUserId(orderInfo.getUserId());
      vipChangeDetail.setCreateTime(UserSession.getCurDateTime());
      this.vipChangeDetailService.saveOrUpdate(vipChangeDetail);
   }
}
