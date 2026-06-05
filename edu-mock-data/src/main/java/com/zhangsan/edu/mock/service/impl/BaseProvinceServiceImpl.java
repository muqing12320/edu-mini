package com.zhangsan.edu.mock.service.impl;

import com.zhangsan.edu.mock.bean.BaseProvince;
import com.zhangsan.edu.mock.mapper.BaseProvinceMapper;
import com.zhangsan.edu.mock.service.BaseProvinceService;
import com.zhangsan.edu.mock.service.adv.impl.AdvServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BaseProvinceServiceImpl extends AdvServiceImpl<BaseProvinceMapper, BaseProvince> implements BaseProvinceService {
}
