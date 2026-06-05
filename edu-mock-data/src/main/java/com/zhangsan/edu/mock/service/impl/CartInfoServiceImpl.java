package com.zhangsan.edu.mock.service.impl;

import com.zhangsan.edu.mock.bean.CartInfo;
import com.zhangsan.edu.mock.mapper.CartInfoMapper;
import com.zhangsan.edu.mock.service.CartInfoService;
import com.zhangsan.edu.mock.service.adv.impl.AdvServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CartInfoServiceImpl extends AdvServiceImpl<CartInfoMapper, CartInfo> implements CartInfoService {
}
