package com.zhangsan.edu.mock.service.impl;

import com.zhangsan.edu.mock.bean.CourseInfo;
import com.zhangsan.edu.mock.bean.OrderInfo;
import com.zhangsan.edu.mock.mapper.OrderInfoMapper;
import com.zhangsan.edu.mock.service.CourseInfoService;
import com.zhangsan.edu.mock.service.OrderInfoService;
import com.zhangsan.edu.mock.service.adv.impl.AdvServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderInfoServiceImpl extends AdvServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {
   @Autowired
   CourseInfoService courseInfoService;

   public List<CourseInfo> getOrderCourseList(Long userId) {
      List<CourseInfo> courseInfoList = new ArrayList();

      for(Long courseId : ((OrderInfoMapper)this.baseMapper).getOrderCourseIdList(userId)) {
         CourseInfo courseInfo = (CourseInfo)this.courseInfoService.getById(courseId, true);
         courseInfoList.add(courseInfo);
      }

      return courseInfoList;
   }
}
