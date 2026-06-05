package com.zhangsan.edu.mock.factory;

import com.zhangsan.edu.mock.service.CartInfoService;
import com.zhangsan.edu.mock.service.CommentInfoService;
import com.zhangsan.edu.mock.service.FavorInfoService;
import com.zhangsan.edu.mock.service.OrderDetailService;
import com.zhangsan.edu.mock.service.OrderInfoService;
import com.zhangsan.edu.mock.service.PaymentInfoService;
import com.zhangsan.edu.mock.service.ReviewInfoService;
import com.zhangsan.edu.mock.service.TestExamQuestionService;
import com.zhangsan.edu.mock.service.TestExamService;
import com.zhangsan.edu.mock.service.UserChapterProcessService;
import com.zhangsan.edu.mock.service.UserInfoService;
import com.zhangsan.edu.mock.service.VipChangeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClearService {
   @Autowired
   OrderInfoService orderInfoService;
   @Autowired
   OrderDetailService orderDetailService;
   @Autowired
   CartInfoService cartInfoService;
   @Autowired
   CommentInfoService commentInfoService;
   @Autowired
   FavorInfoService favorInfoService;
   @Autowired
   ReviewInfoService reviewInfoService;
   @Autowired
   TestExamService testExamService;
   @Autowired
   TestExamQuestionService testExamQuestionService;
   @Autowired
   VipChangeDetailService vipChangeDetailService;
   @Autowired
   PaymentInfoService paymentInfoService;
   @Autowired
   UserInfoService userInfoService;
   @Autowired
   UserChapterProcessService userChapterProcessService;

   public void clearBusi() {
      this.orderInfoService.removeWithCache();
      this.orderDetailService.removeWithCache();
      this.paymentInfoService.removeWithCache();
      this.vipChangeDetailService.removeWithCache();
      this.testExamService.removeWithCache();
      this.testExamQuestionService.removeWithCache();
      this.vipChangeDetailService.removeWithCache();
      this.reviewInfoService.removeWithCache();
      this.commentInfoService.removeWithCache();
      this.favorInfoService.removeWithCache();
      this.userChapterProcessService.removeWithCache();
   }
}
