package com.zhangsan.edu.mock.service.impl;

import com.zhangsan.edu.mock.bean.UserChapterProcess;
import com.zhangsan.edu.mock.mapper.UserChapterProcessMapper;
import com.zhangsan.edu.mock.service.UserChapterProcessService;
import com.zhangsan.edu.mock.service.adv.impl.AdvServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserChapterProcessServiceImpl extends AdvServiceImpl<UserChapterProcessMapper, UserChapterProcess> implements UserChapterProcessService {
}
