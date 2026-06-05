package com.zhangsan.edu.mock.stage;

import com.zhangsan.edu.mock.config.AppConfig;
import com.zhangsan.edu.mock.factory.UserSession;
import com.zhangsan.edu.mock.log.AppCommon;
import com.zhangsan.edu.mock.log.AppDisplay;
import com.zhangsan.edu.mock.log.AppMain;
import com.zhangsan.edu.mock.log.AppPage;
import com.zhangsan.edu.mock.log.enums.ItemType;
import com.zhangsan.edu.mock.log.enums.PageId;
import com.zhangsan.edu.mock.util.LogUtil;
import com.zhangsan.edu.mock.util.RandomBox;
import com.zhangsan.edu.mock.util.RandomNum;
import java.util.List;
import org.springframework.stereotype.Component;

@Component("courseList")
public class CourseListStage implements Stage {
   public boolean handle() {
      AppMain mainlog = this.mainlog();
      LogUtil.logToJson(mainlog);
      UserSession.setLastPageId(PageId.course_list);
      return true;
   }

   private AppMain mainlog() {
      AppCommon appCommon = UserSession.getAppCommon();
      String item = (new RandomBox(AppConfig.searchKeywords)).getRandStringValue();
      Integer durTime = RandomNum.getRandInt(5000, AppConfig.page_during_max_ms);
      AppPage appPage = AppPage.builder().last_page_id(UserSession.getLastPageId()).item_type(ItemType.keyword).item(item).during_time(durTime).page_id(PageId.course_list).build();
      List<AppDisplay> appDisplayList = AppDisplay.buildList();
      UserSession.addTimeByDuringTime(durTime);
      AppMain appMain = AppMain.builder().common(appCommon).page(appPage).displays(appDisplayList).ts(UserSession.getCurDateTime().getTime()).checkError().build();
      return appMain;
   }
}
