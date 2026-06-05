package com.zhangsan.edu.mock.mapper;

import com.zhangsan.edu.mock.bean.ChapterInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

public interface ChapterInfoMapper extends BaseMapper<ChapterInfo> {
   List<ChapterInfo> getChapterWithVideo();
}
