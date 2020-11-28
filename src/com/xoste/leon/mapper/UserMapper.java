package com.xoste.leon.mapper;

import com.xoste.leon.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Xoste
 */
public interface UserMapper {

    /**
     * 通过User对象查询User
     * @param user User
     * @return User
     */
    @Select("select * from t_user where username = #{username} and password = #{password}")
    User selectUserByUsernamePassword(User user);
}
