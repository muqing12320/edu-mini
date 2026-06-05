package com.zhangsan.edu.mock.service;

import com.zhangsan.edu.mock.bean.TestPaper;
import com.zhangsan.edu.mock.service.adv.AdvService;

public interface TestPaperService extends AdvService<TestPaper> {
   TestPaper getRandPaperFromCourse(Long courseId);

   void initPaper();
}
