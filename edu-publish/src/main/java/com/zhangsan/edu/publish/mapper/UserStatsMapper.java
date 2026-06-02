package com.zhangsan.edu.publish.mapper;

import com.zhangsan.edu.publish.bean.UserChangeCtPerType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserStatsMapper {
    @Select("select 'back_count'          type,\n" +
            "       sum(back_count)    back_count\n" +
            "from dws_user_login_window\n" +
            "where toYYYYMMDD(stt) = #{date}\n" +
            "union all\n" +
            "select 'activeUserCt'     type,\n" +
            "       sum(uv_count)      uv_count\n" +
            "from dws_user_login_window\n" +
            "where toYYYYMMDD(stt) = #{date}\n" +
            "union all\n" +
            "select 'newUserCt' type,\n" +
            "       sum(register_count) register_count\n" +
            "from dws_user_register_window\n" +
//            "where toYYYYMMDD(stt) = #{date}" +
            ";")
    List<UserChangeCtPerType> selectUserChangeCtPerType(@Param("date")Integer date);
}
