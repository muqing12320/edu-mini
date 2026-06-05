package com.zhangsan.edu.mock.service.impl;

import com.zhangsan.edu.mock.bean.ChapterInfo;
import com.zhangsan.edu.mock.mapper.ChapterInfoMapper;
import com.zhangsan.edu.mock.service.ChapterInfoService;
import com.zhangsan.edu.mock.service.adv.impl.AdvServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ChapterInfoServiceImpl extends AdvServiceImpl<ChapterInfoMapper, ChapterInfo> implements ChapterInfoService {
}
