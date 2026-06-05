package com.zhangsan.edu.mock.service.impl;

import com.zhangsan.edu.mock.bean.KnowledgePoint;
import com.zhangsan.edu.mock.mapper.KnowledgePointMapper;
import com.zhangsan.edu.mock.service.KnowledgePointService;
import com.zhangsan.edu.mock.service.adv.impl.AdvServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class KnowledgePointServiceImpl extends AdvServiceImpl<KnowledgePointMapper, KnowledgePoint> implements KnowledgePointService {
}
