package com.circle.service;

import com.circle.dao.UserMapper;
import com.circle.pojo.User;

public class UserServiceImpl implements UserService {
    private UserMapper userMapper;
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    public User checkLogin(String username, String password) {
        return userMapper.checkLogin(username, password);
    }
}
