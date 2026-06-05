package com.zhangsan.edu.mock.stage;

import com.zhangsan.edu.mock.bean.OrderInfo;
import com.zhangsan.edu.mock.factory.UserSession;
import com.zhangsan.edu.mock.service.OrderInfoService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("end")
public class EndStage implements Stage {
   @Autowired
   OrderInfoService orderInfoService;

   public boolean handle() {
      this.expireOrder();
      return true;
   }

   private void expireOrder() {
      OrderInfo orderInfo = UserSession.getOrderInfo();
      if (orderInfo != null && orderInfo.getOrderStatus().equals("1001")) {
         orderInfo.setOrderStatus("1003");
         orderInfo.setUpdateTime(DateUtils.addMinutes(UserSession.getCurDateTime(), 15));
         this.orderInfoService.saveOrUpdate(orderInfo);
      }

   }
}
