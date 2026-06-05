package com.zhangsan.edu.mock.service.impl;

import com.zhangsan.edu.mock.bean.BaseSubjectInfo;
import com.zhangsan.edu.mock.mapper.BaseSubjectInfoMapper;
import com.zhangsan.edu.mock.service.SubjectInfoService;
import com.zhangsan.edu.mock.service.adv.impl.AdvServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SubjectInfoServiceImpl extends AdvServiceImpl<BaseSubjectInfoMapper, BaseSubjectInfo> implements SubjectInfoService {
}
