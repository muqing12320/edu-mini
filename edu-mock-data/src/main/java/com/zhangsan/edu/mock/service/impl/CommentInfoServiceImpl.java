package com.zhangsan.edu.mock.service.impl;

import com.zhangsan.edu.mock.bean.CommentInfo;
import com.zhangsan.edu.mock.mapper.CommentInfoMapper;
import com.zhangsan.edu.mock.service.CommentInfoService;
import com.zhangsan.edu.mock.service.adv.impl.AdvServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CommentInfoServiceImpl extends AdvServiceImpl<CommentInfoMapper, CommentInfo> implements CommentInfoService {
}
