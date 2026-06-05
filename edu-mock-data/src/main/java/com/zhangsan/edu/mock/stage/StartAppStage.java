package com.zhangsan.edu.mock.stage;

import com.alibaba.fastjson.JSON;
import com.zhangsan.edu.mock.config.AppConfig;
import com.zhangsan.edu.mock.factory.UserSession;
import com.zhangsan.edu.mock.log.AppCommon;
import com.zhangsan.edu.mock.log.AppMain;
import com.zhangsan.edu.mock.log.AppStart;
import com.zhangsan.edu.mock.util.LogUtil;
import com.zhangsan.edu.mock.util.RandomNum;
import org.springframework.stereotype.Component;

@Component("startApp")
public class StartAppStage implements Stage {
   public boolean handle() {
      this.log();
      return true;
   }

   private void log() {
      AppCommon appCommon = UserSession.getAppCommon();
      AppStart appStart = AppStart.builder().build();
      Integer durTime = RandomNum.getRandInt(5000, AppConfig.page_during_max_ms);
      UserSession.addTimeByDuringTime(durTime);
      Long ts = UserSession.getCurDateTime().getTime();
      AppMain appMain = AppMain.builder().common(appCommon).start(appStart).ts(ts).checkError().build();
      String logJson = JSON.toJSONString(appMain);
      LogUtil.log(logJson);
   }
}
