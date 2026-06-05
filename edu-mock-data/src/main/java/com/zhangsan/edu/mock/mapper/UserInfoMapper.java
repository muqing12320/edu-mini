package com.zhangsan.edu.mock.mapper;

import com.zhangsan.edu.mock.bean.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
   @Update({"truncate table user_info"})
   void truncateUserInfo();
}
