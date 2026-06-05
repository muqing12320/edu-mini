package com.zhangsan.edu.mock.service.impl;

import com.zhangsan.edu.mock.bean.CourseInfo;
import com.zhangsan.edu.mock.bean.TestPaper;
import com.zhangsan.edu.mock.bean.TestPaperQuestion;
import com.zhangsan.edu.mock.bean.TestQuestionInfo;
import com.zhangsan.edu.mock.config.AppConfig;
import com.zhangsan.edu.mock.mapper.TestPaperMapper;
import com.zhangsan.edu.mock.service.CourseInfoService;
import com.zhangsan.edu.mock.service.TestPaperQuestionService;
import com.zhangsan.edu.mock.service.TestPaperService;
import com.zhangsan.edu.mock.service.TestQuestionInfoService;
import com.zhangsan.edu.mock.service.adv.impl.AdvServiceImpl;
import com.zhangsan.edu.mock.util.RandomCollection;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestPaperServiceImpl extends AdvServiceImpl<TestPaperMapper, TestPaper> implements TestPaperService {
   Map<Long, List<TestPaper>> coursePaperCache;
   @Autowired
   CourseInfoService courseInfoService;
   @Autowired
   TestQuestionInfoService testQuestionInfoService;
   @Autowired
   TestPaperQuestionService testPaperQuestionService;

   @Transactional
   public void initPaper() {
      this.removeWithCache();
      this.testPaperQuestionService.removeWithCache();
      Map<Long, CourseInfo> courseInfoMap = this.courseInfoService.all(true);
      List<TestPaper> testPaperList = new ArrayList(courseInfoMap.size());

      for(CourseInfo courseInfo : courseInfoMap.values()) {
         TestPaper testPaper = new TestPaper();
         testPaper.setPaperTitle(courseInfo.getCourseName() + "测试");
         testPaper.setCourseId(courseInfo.getId());
         testPaper.setCreateTime(new Date());
         testPaper.setDeleted("0");
         testPaper.setPublisherId(99L);
         testPaperList.add(testPaper);
      }

      this.saveOrUpdateBatch(testPaperList, 1000, true);
      List<TestPaperQuestion> testPaperQuestionALL = new ArrayList(courseInfoMap.size() * AppConfig.mock_init_paper_max_q);

      for(TestPaper testPaper : testPaperList) {
         List<TestPaperQuestion> testPaperQuestionList = this.initTestPaperQuestion(testPaper);
         testPaperQuestionALL.addAll(testPaperQuestionList);
      }

      this.testPaperQuestionService.saveOrUpdateBatch(testPaperQuestionALL, 1000, true);
      this.loadCache();
   }

   public List<TestPaperQuestion> initTestPaperQuestion(TestPaper testPaper) {
      List<TestQuestionInfo> questionInfoList = this.testQuestionInfoService.list((Wrapper)(new QueryWrapper()).eq("course_id", testPaper.getCourseId()));
      if (questionInfoList.size() > AppConfig.mock_init_paper_max_q) {
         List<TestQuestionInfo> testQuestionInfoList = RandomCollection.getSomeFrom(questionInfoList, AppConfig.mock_init_paper_max_q);
         return this.initQuestInfosToPaperQuestList(testPaper, testQuestionInfoList);
      } else if (questionInfoList.size() % 2 != 0 && questionInfoList.size() != 1) {
         List<TestQuestionInfo> testQuestionInfoList = RandomCollection.getSomeFrom(questionInfoList, questionInfoList.size() - 1);
         return this.initQuestInfosToPaperQuestList(testPaper, testQuestionInfoList);
      } else {
         return this.initQuestInfosToPaperQuestList(testPaper, questionInfoList);
      }
   }

   public List<TestPaperQuestion> initQuestInfosToPaperQuestList(TestPaper testPaper, List<TestQuestionInfo> questionInfoList) {
      List<TestPaperQuestion> testPaperQuestionList = new ArrayList(questionInfoList.size());
      System.out.println("quest.size:" + questionInfoList.size());
      System.out.println("testPaper:" + testPaper);
      BigDecimal scorePerQ = (new BigDecimal(100)).divide(new BigDecimal(questionInfoList.size()), 1, RoundingMode.HALF_UP);

      for(TestQuestionInfo testQuestionInfo : questionInfoList) {
         TestPaperQuestion testPaperQuestion = new TestPaperQuestion();
         testPaperQuestion.setPaperId(testPaper.getId());
         testPaperQuestion.setScore(scorePerQ);
         testPaperQuestion.setCreateTime(new Date());
         testPaperQuestion.setQuestionId(testQuestionInfo.getId());
         testPaperQuestion.setPublisherId(99L);
         testPaperQuestionList.add(testPaperQuestion);
      }

      return testPaperQuestionList;
   }

   public TestPaper getRandPaperFromCourse(Long courseId) {
      List<TestPaper> testPaperList = (List)this.coursePaperCache.get(courseId);
      if (testPaperList != null) {
         TestPaper testPaper = (TestPaper)RandomCollection.getOneFrom(testPaperList);
         return testPaper;
      } else {
         return null;
      }
   }

   @PostConstruct
   protected void loadCache() {
      this.cache = new ConcurrentHashMap();
      this.coursePaperCache = new ConcurrentHashMap();
      List<TestPaper> list = ((TestPaperMapper)this.baseMapper).selectPaperWithQuestion();
      this.loadCache(list);
      this.loadCoursePaperMap(list);
   }

   private void loadCoursePaperMap(List<TestPaper> list) {
      for(TestPaper testPaper : list) {
         List<TestPaper> testPaperList = (List)this.coursePaperCache.get(testPaper.getCourseId());
         if (testPaperList != null) {
            testPaperList.add(testPaper);
         } else {
            testPaperList = new ArrayList();
            testPaperList.add(testPaper);
            this.coursePaperCache.put(testPaper.getCourseId(), testPaperList);
         }
      }

   }
}
