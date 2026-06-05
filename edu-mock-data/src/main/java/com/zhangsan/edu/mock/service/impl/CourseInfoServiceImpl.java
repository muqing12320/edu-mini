package com.zhangsan.edu.mock.service.impl;

import com.zhangsan.edu.mock.bean.CourseInfo;
import com.zhangsan.edu.mock.mapper.CourseInfoMapper;
import com.zhangsan.edu.mock.service.ChapterInfoService;
import com.zhangsan.edu.mock.service.CourseInfoService;
import com.zhangsan.edu.mock.service.adv.impl.AdvServiceImpl;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseInfoServiceImpl extends AdvServiceImpl<CourseInfoMapper, CourseInfo> implements CourseInfoService {
   @Autowired
   ChapterInfoService chapterInfoService;

   @PostConstruct
   protected void loadCache() {
      this.cache = new ConcurrentHashMap();
      List<CourseInfo> list = ((CourseInfoMapper)this.baseMapper).selectCourseInfoWithChapter();
      this.loadCache(list);
   }
}
