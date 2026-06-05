package com.zhangsan.edu.mock.service.impl;

import com.zhangsan.edu.mock.bean.TestPaperQuestion;
import com.zhangsan.edu.mock.mapper.TestPaperQuestionMapper;
import com.zhangsan.edu.mock.service.TestPaperQuestionService;
import com.zhangsan.edu.mock.service.adv.impl.AdvServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TestPaperQuestionServiceImpl extends AdvServiceImpl<TestPaperQuestionMapper, TestPaperQuestion> implements TestPaperQuestionService {
}
