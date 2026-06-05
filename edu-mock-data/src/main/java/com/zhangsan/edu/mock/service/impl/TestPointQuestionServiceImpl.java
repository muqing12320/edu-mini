package com.zhangsan.edu.mock.service.impl;

import com.zhangsan.edu.mock.bean.TestPointQuestion;
import com.zhangsan.edu.mock.mapper.TestPointQuestionMapper;
import com.zhangsan.edu.mock.service.TestPointQuestionService;
import com.zhangsan.edu.mock.service.adv.impl.AdvServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TestPointQuestionServiceImpl extends AdvServiceImpl<TestPointQuestionMapper, TestPointQuestion> implements TestPointQuestionService {
}
