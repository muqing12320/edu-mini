package com.zhangsan.edu.mock.service.impl;

import com.zhangsan.edu.mock.bean.TestQuestionInfo;
import com.zhangsan.edu.mock.mapper.TestQuestionInfoMapper;
import com.zhangsan.edu.mock.service.TestQuestionInfoService;
import com.zhangsan.edu.mock.service.adv.impl.AdvServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TestQuestionInfoServiceImpl extends AdvServiceImpl<TestQuestionInfoMapper, TestQuestionInfo> implements TestQuestionInfoService {
}
