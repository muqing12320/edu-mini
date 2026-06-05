package com.zhangsan.edu.mock.service.impl;

import com.zhangsan.edu.mock.bean.OrderDetail;
import com.zhangsan.edu.mock.mapper.OrderDetailMapper;
import com.zhangsan.edu.mock.service.OrderDetailService;
import com.zhangsan.edu.mock.service.adv.impl.AdvServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends AdvServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}
