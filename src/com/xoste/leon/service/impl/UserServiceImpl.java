package com.xoste.leon.service.impl;

import com.xoste.leon.mapper.UserMapper;
import com.xoste.leon.pojo.User;
import com.xoste.leon.service.UserService;

/**
 * @author Xoste
 */
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User loginUser(User user) {
        return userMapper.selectUserByUsernamePassword(user);
    }
}
