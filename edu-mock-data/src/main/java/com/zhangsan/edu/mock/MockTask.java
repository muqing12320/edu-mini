package com.zhangsan.edu.mock;

import com.zhangsan.edu.mock.config.AppConfig;
import com.zhangsan.edu.mock.factory.ClearService;
import com.zhangsan.edu.mock.factory.UserStageChain;
import com.zhangsan.edu.mock.factory.UserStageChainFactory;
import com.zhangsan.edu.mock.service.TestPaperService;
import com.zhangsan.edu.mock.service.UserInfoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class MockTask {
   private static final Logger log = LoggerFactory.getLogger(MockTask.class);
   @Autowired
   ThreadPoolTaskExecutor poolExecutor;
   @Autowired
   ClearService clearService;
   @Autowired
   UserInfoService userInfoService;
   @Autowired
   TestPaperService testPaperService;

   public void mainTask() {
      System.out.println("=== 当前配置 ===");
      System.out.println("mock_clear_user: " + AppConfig.mock_clear_user);
      System.out.println("mock_new_user: " + AppConfig.mock_new_user);
      System.out.println("mock_clear_busi: " + AppConfig.mock_clear_busi);
      System.out.println("mock_date: " + AppConfig.mock_date_str);
      System.out.println("===============");

      if (AppConfig.mock_clear_busi.equals("1")) {
         System.out.println("---初始化清理业务数据----");
         this.clearService.clearBusi();
         System.out.println("--- 清理业务数据完成----");
      }

      if (AppConfig.if_init_paper.equals("1")) {
         System.out.println("---初始化试卷----");
         this.testPaperService.initPaper();
         System.out.println("--- 试卷初始化完成----");
      }

      System.out.println("---初始化用户会话，预计初始化：" + AppConfig.user_session_count + " 个 ---");
      UserStageChainFactory userStageChainFactory = UserStageChainFactory.builder()
              .userSessionCount(AppConfig.user_session_count)
              .build();
      List<UserStageChain> userStageChainList = userStageChainFactory.produce();
      System.out.println("---初始化会话路径完成，开始多线程推演：" + userStageChainList.size() + "   ---");

      for(UserStageChain userStageChain : userStageChainList) {
         log.debug("访问流程:" + userStageChain.getVisitStages());
         log.debug("学习流程:" + userStageChain.getStudyStages());
         this.poolExecutor.execute(userStageChain);
         log.debug("active+" + this.poolExecutor.getActiveCount());
      }

      while(true) {
         try {
            Thread.sleep(1000L);
            System.out.println("---演算中...---");
            if (this.poolExecutor.getActiveCount() == 0) {
               System.out.println("---演算完成  ---");
               this.poolExecutor.destroy();
               return;
            }
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}
