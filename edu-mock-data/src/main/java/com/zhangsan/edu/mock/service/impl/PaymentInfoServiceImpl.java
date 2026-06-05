package com.zhangsan.edu.mock.service.impl;

import com.zhangsan.edu.mock.bean.PaymentInfo;
import com.zhangsan.edu.mock.mapper.PaymentInfoMapper;
import com.zhangsan.edu.mock.service.PaymentInfoService;
import com.zhangsan.edu.mock.service.adv.impl.AdvServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PaymentInfoServiceImpl extends AdvServiceImpl<PaymentInfoMapper, PaymentInfo> implements PaymentInfoService {
}
