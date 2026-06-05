package com.zhangsan.edu.mock.service.impl;

import com.zhangsan.edu.mock.bean.FavorInfo;
import com.zhangsan.edu.mock.mapper.FavorInfoMapper;
import com.zhangsan.edu.mock.service.FavorInfoService;
import com.zhangsan.edu.mock.service.adv.impl.AdvServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class FavorInfoServiceImpl extends AdvServiceImpl<FavorInfoMapper, FavorInfo> implements FavorInfoService {
}
