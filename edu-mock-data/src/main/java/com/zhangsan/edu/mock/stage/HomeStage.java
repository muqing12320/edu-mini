package com.zhangsan.edu.mock.stage;

import com.zhangsan.edu.mock.factory.UserSession;
import com.zhangsan.edu.mock.log.AppCommon;
import com.zhangsan.edu.mock.log.AppDisplay;
import com.zhangsan.edu.mock.log.AppMain;
import com.zhangsan.edu.mock.log.AppPage;
import com.zhangsan.edu.mock.log.enums.PageId;
import com.zhangsan.edu.mock.util.LogUtil;
import java.util.List;
import org.springframework.stereotype.Component;

@Component("home")
public class HomeStage implements Stage {
   public boolean handle() {
      AppMain appMain = this.mainlog();
      LogUtil.logToJson(appMain);
      UserSession.setLastPageId(PageId.home);
      return true;
   }

   private AppMain mainlog() {
      AppCommon appCommon = UserSession.getAppCommon();
      AppPage appPage = AppPage.builder().page_id(PageId.home).build();
      List<AppDisplay> appDisplayList = AppDisplay.buildList();
      UserSession.addTimeByDuringTime(appPage.getDuring_time());
      Long ts = UserSession.getCurDateTime().getTime();
      AppMain appMain = AppMain.builder().common(appCommon).page(appPage).displays(appDisplayList).ts(ts).checkError().build();
      return appMain;
   }
}
