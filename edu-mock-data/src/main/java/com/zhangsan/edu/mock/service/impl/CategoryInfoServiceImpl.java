package com.zhangsan.edu.mock.service.impl;

import com.zhangsan.edu.mock.bean.BaseCategoryInfo;
import com.zhangsan.edu.mock.mapper.BaseCategoryInfoMapper;
import com.zhangsan.edu.mock.service.CategoryInfoService;
import com.zhangsan.edu.mock.service.adv.impl.AdvServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CategoryInfoServiceImpl extends AdvServiceImpl<BaseCategoryInfoMapper, BaseCategoryInfo> implements CategoryInfoService {
}
