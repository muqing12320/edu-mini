package com.zhangsan.edu.mock.stage;

import com.zhangsan.edu.mock.config.AppConfig;
import com.zhangsan.edu.mock.factory.UserSession;
import com.zhangsan.edu.mock.log.AppCommon;
import com.zhangsan.edu.mock.log.AppMain;
import com.zhangsan.edu.mock.log.AppPage;
import com.zhangsan.edu.mock.log.enums.PageId;
import com.zhangsan.edu.mock.util.LogUtil;
import com.zhangsan.edu.mock.util.RandomNum;
import org.springframework.stereotype.Component;

@Component("register")
public class RegisterStage implements Stage {

    @Override
    public boolean handle() {
        AppMain appMain = this.mainLog();
        LogUtil.logToJson(appMain);
        UserSession.setLastPageId(PageId.register);
        return true;
    }

    private AppMain mainLog() {
        AppCommon appCommon = UserSession.getAppCommon();
        Integer durTime = RandomNum.getRandInt(5000, AppConfig.page_during_max_ms);
        AppPage appPage = AppPage.builder()
                .last_page_id(UserSession.getLastPageId())
                .during_time(durTime)
                .page_id(PageId.register)
                .build();

        UserSession.addTimeByDuringTime(durTime);
        Long ts = UserSession.getCurDateTime().getTime();

        AppMain appMain = AppMain.builder()
                .common(appCommon)
                .page(appPage)
                .ts(ts)
                .checkError()
                .build();

        return appMain;
    }
}
