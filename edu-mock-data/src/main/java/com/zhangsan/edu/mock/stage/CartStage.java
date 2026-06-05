package com.zhangsan.edu.mock.stage;

import com.zhangsan.edu.mock.config.AppConfig;
import com.zhangsan.edu.mock.factory.UserSession;
import com.zhangsan.edu.mock.log.AppCommon;
import com.zhangsan.edu.mock.log.AppDisplay;
import com.zhangsan.edu.mock.log.AppMain;
import com.zhangsan.edu.mock.log.AppPage;
import com.zhangsan.edu.mock.log.enums.PageId;
import com.zhangsan.edu.mock.util.LogUtil;
import com.zhangsan.edu.mock.util.RandomNum;
import java.util.List;
import org.springframework.stereotype.Component;

@Component("cart")
public class CartStage implements Stage {
   public boolean handle() {
      AppMain appMain = this.mainLog();
      LogUtil.logToJson(appMain);
      UserSession.setLastPageId(PageId.cart);
      return true;
   }

   private AppMain mainLog() {
      AppCommon appCommon = UserSession.getAppCommon();
      Integer durTime = RandomNum.getRandInt(5000, AppConfig.page_during_max_ms);
      AppPage appPage = AppPage.builder().last_page_id(UserSession.getLastPageId()).during_time(durTime).page_id(PageId.cart).build();
      List<AppDisplay> appDisplayList = AppDisplay.buildList();
      UserSession.addTimeByDuringTime(appPage.getDuring_time());
      AppMain appMain = AppMain.builder().common(appCommon).page(appPage).displays(appDisplayList).ts(UserSession.getCurDateTime().getTime()).checkError().build();
      return appMain;
   }
}
