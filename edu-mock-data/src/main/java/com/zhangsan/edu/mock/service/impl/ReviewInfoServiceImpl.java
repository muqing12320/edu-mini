package com.zhangsan.edu.mock.service.impl;

import com.zhangsan.edu.mock.bean.ReviewInfo;
import com.zhangsan.edu.mock.mapper.ReviewInfoMapper;
import com.zhangsan.edu.mock.service.ReviewInfoService;
import com.zhangsan.edu.mock.service.adv.impl.AdvServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ReviewInfoServiceImpl extends AdvServiceImpl<ReviewInfoMapper, ReviewInfo> implements ReviewInfoService {
}
