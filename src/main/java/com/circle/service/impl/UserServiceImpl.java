package com.circle.service.impl;

import com.circle.mapper.UserMapper;
import com.circle.pojo.User;
import com.circle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    public User checkLogin(String username, String password) {
        return userMapper.checkLogin(username, password);
    }
}
