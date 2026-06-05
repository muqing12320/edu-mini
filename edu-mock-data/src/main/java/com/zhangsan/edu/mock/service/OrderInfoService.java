package com.zhangsan.edu.mock.service;

import com.zhangsan.edu.mock.bean.CourseInfo;
import com.zhangsan.edu.mock.bean.OrderInfo;
import com.zhangsan.edu.mock.service.adv.AdvService;
import java.util.List;

public interface OrderInfoService extends AdvService<OrderInfo> {
   List<CourseInfo> getOrderCourseList(Long userId);
}
