package com.xoste.leon.service;

import com.xoste.leon.pojo.User;

/**
 * @author Xoste
 */
public interface UserService {
    /**
     * 用户登录
     * @param user User
     * @return User
     */
    User loginUser(User user);
}
