package com.zhangsan.edu.mock.stage;

import com.zhangsan.edu.mock.bean.CourseInfo;
import com.zhangsan.edu.mock.bean.TestExam;
import com.zhangsan.edu.mock.bean.TestExamQuestion;
import com.zhangsan.edu.mock.bean.TestPaper;
import com.zhangsan.edu.mock.bean.TestQuestionInfo;
import com.zhangsan.edu.mock.bean.TestQuestionOption;
import com.zhangsan.edu.mock.config.AppConfig;
import com.zhangsan.edu.mock.factory.UserSession;
import com.zhangsan.edu.mock.log.AppCommon;
import com.zhangsan.edu.mock.log.AppMain;
import com.zhangsan.edu.mock.log.AppPage;
import com.zhangsan.edu.mock.log.enums.ItemType;
import com.zhangsan.edu.mock.log.enums.PageId;
import com.zhangsan.edu.mock.service.TestExamQuestionService;
import com.zhangsan.edu.mock.service.TestExamService;
import com.zhangsan.edu.mock.service.TestPaperService;
import com.zhangsan.edu.mock.util.LogUtil;
import com.zhangsan.edu.mock.util.RandomBox;
import com.zhangsan.edu.mock.util.RandomNum;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("exam")
public class ExamStage implements Stage {
   @Autowired
   TestPaperService testPaperService;
   @Autowired
   TestExamService testExamService;
   @Autowired
   TestExamQuestionService testExamQuestionService;

   public boolean handle() {
      TestExam testExam = this.initExam();
      if (testExam == null) {
         return false;
      } else {
         this.saveExam(testExam);
         AppMain appMain = this.mainLog(testExam);
         LogUtil.logToJson(appMain);
         UserSession.setLastPageId(PageId.exam);
         return true;
      }
   }

   private TestExam initExam() {
      CourseInfo curCourseInfo = UserSession.getCurCourseInfo();
      TestPaper testPaper = this.testPaperService.getRandPaperFromCourse(curCourseInfo.getId());
      if (testPaper == null) {
         return null;
      } else {
         Integer durTime = RandomNum.getRandInt(300, 1500);
         UserSession.addTimeByDuringTime((durTime + 10) * 1000);
         TestExam testExam = new TestExam();
         testExam.setPaperId(testPaper.getId());
         testExam.setDurationSec(durTime);
         testExam.setSubmitTime(UserSession.getCurDateTime());
         testExam.setCreateTime(UserSession.getCurDateTime());
         testExam.setDeleted("0");
         testExam.setUserId(UserSession.getUserInfo().getId());
         List<TestExamQuestion> testExamQuestionList = new ArrayList();
         List<TestQuestionInfo> testQuestionInfoList = testPaper.getTestQuestionInfoList();
         BigDecimal totalScore = BigDecimal.ZERO;

         for(TestQuestionInfo testQuestionInfo : testQuestionInfoList) {
            TestExamQuestion examQuestion = this.initExamQuestion(testPaper, testQuestionInfo);
            testExamQuestionList.add(examQuestion);
            totalScore = totalScore.add(examQuestion.getScore());
         }

         testExam.setTestExamQuestionList(testExamQuestionList);
         testExam.setScore(totalScore);
         return testExam;
      }
   }

   private TestExamQuestion initExamQuestion(TestPaper paper, TestQuestionInfo questionInfo) {
      TestExamQuestion testExamQuestion = new TestExamQuestion();
      testExamQuestion.setPaperId(paper.getId());
      testExamQuestion.setQuestionId(questionInfo.getId());
      testExamQuestion.setUserId(UserSession.getUserInfo().getId());
      Integer exam_corrent_rate = AppConfig.exam_corrent_rate;
      RandomBox examBox = new RandomBox(exam_corrent_rate, 100 - exam_corrent_rate);
      List<TestQuestionOption> testQuestionOptionList = questionInfo.getTestQuestionOptionList();
      List<String> answerList = new ArrayList();
      Boolean isCorrect = examBox.getRandBoolValue();

      for(TestQuestionOption testQuestionOption : testQuestionOptionList) {
         if (isCorrect) {
            if (testQuestionOption.getIsCorrect().equals("1")) {
               answerList.add(testQuestionOption.getId().toString());
            }
         } else if (testQuestionOption.getIsCorrect().equals("0")) {
            answerList.add(testQuestionOption.getId().toString());
         }
      }

      String answer = StringUtils.join(answerList, ",");
      testExamQuestion.setAnswer(answer);
      if (isCorrect) {
         testExamQuestion.setScore(questionInfo.getScore());
         testExamQuestion.setIsCorrect("1");
      } else {
         testExamQuestion.setScore(BigDecimal.ZERO);
         testExamQuestion.setIsCorrect("0");
      }

      testExamQuestion.setCreateTime(UserSession.getCurDateTime());
      testExamQuestion.setDeleted("0");
      return testExamQuestion;
   }

   public void saveExam(TestExam exam) {
      this.testExamService.saveOrUpdate(exam);

      for(TestExamQuestion testExamQuestion : exam.getTestExamQuestionList()) {
         testExamQuestion.setExamId(exam.getId());
      }

      this.testExamQuestionService.saveOrUpdateBatch(exam.getTestExamQuestionList(), 100);
   }

   public AppMain mainLog(TestExam testExam) {
      AppCommon appCommon = UserSession.getAppCommon();
      AppPage appPage = AppPage.builder().last_page_id(UserSession.getLastPageId()).during_time(testExam.getDurationSec() * 1000).item_type(ItemType.paper_id).item(testExam.getPaperId().toString()).page_id(PageId.exam).build();
      AppMain appMain = AppMain.builder().common(appCommon).page(appPage).ts(UserSession.getCurDateTime().getTime()).checkError().build();
      return appMain;
   }
}
