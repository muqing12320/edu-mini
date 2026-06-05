package com.zhangsan.edu.mock.mapper;

import com.zhangsan.edu.mock.bean.TestPaper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

public interface TestPaperMapper extends BaseMapper<TestPaper> {
   List<TestPaper> selectPaperWithQuestion();
}
