package com.zhangsan.edu.mock.mapper;

import com.zhangsan.edu.mock.bean.CourseInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

public interface CourseInfoMapper extends BaseMapper<CourseInfo> {
   List<CourseInfo> selectCourseInfoWithChapter();
}
