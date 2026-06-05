package com.zhangsan.edu.mock.service.impl;

import com.zhangsan.edu.mock.bean.TestExamQuestion;
import com.zhangsan.edu.mock.mapper.TestExamQuestionMapper;
import com.zhangsan.edu.mock.service.TestExamQuestionService;
import com.zhangsan.edu.mock.service.adv.impl.AdvServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TestExamQuestionServiceImpl extends AdvServiceImpl<TestExamQuestionMapper, TestExamQuestion> implements TestExamQuestionService {
}
