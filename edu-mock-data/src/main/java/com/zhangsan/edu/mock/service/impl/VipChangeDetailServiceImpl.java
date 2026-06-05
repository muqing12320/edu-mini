package com.zhangsan.edu.mock.service.impl;

import com.zhangsan.edu.mock.bean.VipChangeDetail;
import com.zhangsan.edu.mock.mapper.VipChangeDetailMapper;
import com.zhangsan.edu.mock.service.VipChangeDetailService;
import com.zhangsan.edu.mock.service.adv.impl.AdvServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class VipChangeDetailServiceImpl extends AdvServiceImpl<VipChangeDetailMapper, VipChangeDetail> implements VipChangeDetailService {
}
