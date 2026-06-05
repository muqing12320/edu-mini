package com.zhangsan.edu.mock.service.impl;

import com.zhangsan.edu.mock.bean.TestQuestionOption;
import com.zhangsan.edu.mock.mapper.TestQuestionOptionsMapper;
import com.zhangsan.edu.mock.service.TestQuestionOptionsService;
import com.zhangsan.edu.mock.service.adv.impl.AdvServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TestQuestionOptionsServiceImpl extends AdvServiceImpl<TestQuestionOptionsMapper, TestQuestionOption> implements TestQuestionOptionsService {
}
