package com.zhangsan.edu.mock.service.impl;

import com.zhangsan.edu.mock.bean.TestExam;
import com.zhangsan.edu.mock.mapper.TestExamMapper;
import com.zhangsan.edu.mock.service.TestExamService;
import com.zhangsan.edu.mock.service.adv.impl.AdvServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TestExamServiceImpl extends AdvServiceImpl<TestExamMapper, TestExam> implements TestExamService {
}
