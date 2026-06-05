package com.zhangsan.edu.mock.stage;

import com.zhangsan.edu.mock.bean.ChapterInfo;
import com.zhangsan.edu.mock.bean.CommentInfo;
import com.zhangsan.edu.mock.bean.CourseInfo;
import com.zhangsan.edu.mock.bean.ReviewInfo;
import com.zhangsan.edu.mock.bean.UserChapterProcess;
import com.zhangsan.edu.mock.config.AppConfig;
import com.zhangsan.edu.mock.factory.UserSession;
import com.zhangsan.edu.mock.log.AppAction;
import com.zhangsan.edu.mock.log.AppCommon;
import com.zhangsan.edu.mock.log.AppDisplay;
import com.zhangsan.edu.mock.log.AppMain;
import com.zhangsan.edu.mock.log.AppPage;
import com.zhangsan.edu.mock.log.AppVideo;
import com.zhangsan.edu.mock.log.enums.ActionId;
import com.zhangsan.edu.mock.log.enums.ItemType;
import com.zhangsan.edu.mock.log.enums.PageId;
import com.zhangsan.edu.mock.service.CommentInfoService;
import com.zhangsan.edu.mock.service.CourseInfoService;
import com.zhangsan.edu.mock.service.ReviewInfoService;
import com.zhangsan.edu.mock.service.UserChapterProcessService;
import com.zhangsan.edu.mock.util.LogUtil;
import com.zhangsan.edu.mock.util.RandomBox;
import com.zhangsan.edu.mock.util.RandomCollection;
import com.zhangsan.edu.mock.util.RandomNum;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("chapterVideo")
public class ChapterVideoStage implements Stage {
   private static final Logger log = LoggerFactory.getLogger(ChapterVideoStage.class);
   @Autowired
   UserChapterProcessService userChapterProcessService;
   @Autowired
   ReviewInfoService reviewInfoService;
   @Autowired
   CommentInfoService commentInfoService;
   @Autowired
   CourseInfoService courseInfoService;

   public boolean handle() {
      ChapterInfo chapterInfo = this.getChapterInfo();
      AppMain appMain = this.mainLog(chapterInfo);
      List<AppMain> videoLogList = this.videoHeartBeat(appMain, chapterInfo);
      LogUtil.logToJson(appMain);

      for(AppMain videoLog : videoLogList) {
         LogUtil.logToJson(videoLog);
      }

      LogUtil.logToJson(appMain);
      this.saveUserChapterProcess(videoLogList, chapterInfo);
      this.handleReview(appMain, UserSession.getCurCourseInfo());
      this.handleComment(appMain, chapterInfo);
      UserSession.setLastPageId(PageId.chapter_video);
      return true;
   }

   private ChapterInfo getChapterInfo() {
      CourseInfo curCourseInfo = UserSession.getCurCourseInfo();
      List<ChapterInfo> chapterInfoList = curCourseInfo.getChapterInfoList();
      ChapterInfo chapterInfo = (ChapterInfo)RandomCollection.getOneFrom(chapterInfoList);
      return chapterInfo;
   }

   private List<AppMain> videoHeartBeat(AppMain appMain, ChapterInfo chapterInfo) {
      Integer videoHeartIntervalSec = AppConfig.video_heart_interval_sec;
      Integer playSecThrehold = (appMain.getPage().getDuring_time() - 5000) / 1000;
      List<AppMain> videoLogList = new ArrayList();
      Integer totalplaySec = videoHeartIntervalSec;

      while(true) {
         int pauseNum = RandomNum.getRandInt(1, AppConfig.video_heart_interval_sec * 10);
         if (totalplaySec >= playSecThrehold) {
            Integer thisIntervalPlaySec = totalplaySec - playSecThrehold;
            AppVideo appVideo = AppVideo.builder().play_sec(thisIntervalPlaySec).video_id(chapterInfo.getVideoId().toString()).position_sec(totalplaySec).build();
            UserSession.addTimeByDuringTime(thisIntervalPlaySec * 1000);
            AppMain appMainV = AppMain.builder().common(appMain.getCommon()).appVideo(appVideo).ts(UserSession.getCurDateTime().getTime()).checkError().build();
            videoLogList.add(appMainV);
            return videoLogList;
         }

         Integer thisIntervalPlaySec = AppConfig.video_heart_interval_sec;
         if (pauseNum < AppConfig.video_heart_interval_sec) {
            thisIntervalPlaySec = thisIntervalPlaySec - pauseNum;
         }

         UserSession.addTimeByDuringTime(thisIntervalPlaySec * 1000);
         AppVideo appVideo = AppVideo.builder().play_sec(thisIntervalPlaySec).video_id(chapterInfo.getVideoId().toString()).position_sec(totalplaySec).build();
         AppMain appMainV = AppMain.builder().common(appMain.getCommon()).appVideo(appVideo).ts(UserSession.getCurDateTime().getTime()).checkError().build();
         videoLogList.add(appMainV);
         totalplaySec = totalplaySec + videoHeartIntervalSec;
      }
   }

   private AppMain mainLog(ChapterInfo chapterInfo) {
      AppCommon appCommon = UserSession.getAppCommon();
      Integer durTime = RandomNum.getRandInt(5000, chapterInfo.getVideoInfo().getDuringSec() * 1000);
      AppPage appPage = AppPage.builder().last_page_id(UserSession.getLastPageId()).item(chapterInfo.getId() + "").extend1(chapterInfo.getVideoId().toString()).item_type(ItemType.chapter_id).during_time(durTime).page_id(PageId.chapter_video).build();
      List<AppDisplay> appDisplayList = AppDisplay.buildList();
      UserSession.addTimeByDuringTime(durTime);
      AppMain appMain = AppMain.builder().common(appCommon).page(appPage).displays(appDisplayList).ts(UserSession.getCurDateTime().getTime()).build();
      return appMain;
   }

   private void saveUserChapterProcess(List<AppMain> appMainList, ChapterInfo chapterInfo) {
      Integer totalPlaySec = 0;

      for(AppMain appMain : appMainList) {
         totalPlaySec = totalPlaySec + appMain.getAppVideo().getPlay_sec();
      }

      UserChapterProcess userChapterProcess = new UserChapterProcess();
      userChapterProcess.setChapterId(chapterInfo.getId());
      userChapterProcess.setCourseId(chapterInfo.getCourseId());
      userChapterProcess.setPositionSec(totalPlaySec);
      userChapterProcess.setCreateTime(UserSession.getCurDateTime());
      userChapterProcess.setUserId(UserSession.getUserInfo().getId());
      userChapterProcess.setDeleted("0");
      this.userChapterProcessService.remove((Wrapper)((QueryWrapper)(new QueryWrapper()).eq("user_id", UserSession.getUserInfo().getId())).eq("chapter_id", chapterInfo.getId()));
      this.userChapterProcessService.saveOrUpdate(userChapterProcess);
   }

   private void handleReview(AppMain appMain, CourseInfo courseInfo) {
      if (UserSession.isStudy()) {
         ReviewInfo existsReviewInfo = (ReviewInfo)this.reviewInfoService.getOne((Wrapper)((QueryWrapper)(new QueryWrapper()).eq("user_id", UserSession.getUserInfo().getId())).eq("course_id", courseInfo.getId()));
         log.debug("" + existsReviewInfo);
         if (existsReviewInfo == null) {
            ReviewInfo reviewInfo = this.initReviewInfo(courseInfo);
            this.reviewInfoService.saveOrUpdate(reviewInfo);
            AppAction reviewAction = new AppAction(ActionId.review_add, ItemType.course_id, courseInfo.getId().toString(), UserSession.getCurDateTime().getTime());
            appMain.addAction(reviewAction);
         }
      }

   }

   public ReviewInfo initReviewInfo(CourseInfo courseInfo) {
      ReviewInfo reviewInfo = new ReviewInfo();
      reviewInfo.setCourseId(courseInfo.getId());
      reviewInfo.setCreateTime(UserSession.getCurDateTime());
      Integer[] appraise_weight = AppConfig.appraise_weight;
      RandomBox<Integer> appraiseBox = RandomBox.builder().add(5, appraise_weight[0]).add(4, appraise_weight[1]).add(3, appraise_weight[2]).add(2, appraise_weight[3]).add(1, appraise_weight[4]).build();
      Integer appraise = (Integer)appraiseBox.getValue();
      reviewInfo.setReviewStars(appraise);
      reviewInfo.setCourseId(courseInfo.getId());
      reviewInfo.setUserId(UserSession.getUserInfo().getId());
      reviewInfo.setUserId(UserSession.getUserInfo().getId());
      reviewInfo.setCreateTime(UserSession.getCurDateTime());
      reviewInfo.setDeleted("0");
      return reviewInfo;
   }

   private void handleComment(AppMain appMain, ChapterInfo chapterInfo) {
      if (UserSession.isStudy()) {
         CommentInfo CommentInfo = this.initCommentInfo(chapterInfo);
         this.commentInfoService.saveOrUpdate(CommentInfo);
         AppAction commentAction = new AppAction(ActionId.comment_add, ItemType.chapter_id, chapterInfo.getId().toString(), UserSession.getCurDateTime().getTime());
         appMain.addAction(commentAction);
      }

   }

   public CommentInfo initCommentInfo(ChapterInfo chapterInfo) {
      CommentInfo commentInfo = new CommentInfo();
      commentInfo.setCommentTxt("评论 123123");
      commentInfo.setChapterId(chapterInfo.getId());
      commentInfo.setCourseId(chapterInfo.getCourseId());
      commentInfo.setUserId(UserSession.getUserInfo().getId());
      commentInfo.setCreateTime(UserSession.getCurDateTime());
      commentInfo.setDeleted("0");
      return commentInfo;
   }
}
