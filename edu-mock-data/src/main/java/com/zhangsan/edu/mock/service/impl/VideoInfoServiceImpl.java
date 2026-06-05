package com.zhangsan.edu.mock.service.impl;

import com.zhangsan.edu.mock.bean.VideoInfo;
import com.zhangsan.edu.mock.mapper.VideoInfoMapper;
import com.zhangsan.edu.mock.service.VideoInfoService;
import com.zhangsan.edu.mock.service.adv.impl.AdvServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class VideoInfoServiceImpl extends AdvServiceImpl<VideoInfoMapper, VideoInfo> implements VideoInfoService {
}
