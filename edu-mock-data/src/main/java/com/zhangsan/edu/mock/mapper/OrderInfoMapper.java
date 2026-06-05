package com.zhangsan.edu.mock.mapper;

import com.zhangsan.edu.mock.bean.OrderInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Select;

public interface OrderInfoMapper extends BaseMapper<OrderInfo> {
   @Select({"select od.course_id  from  order_info oi , order_detail od where oi.id =od.order_id and order_status='1002' and oi.user_id=#{userId}"})
   List<Long> getOrderCourseIdList(Long userId);
}
