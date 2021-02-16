package com.circle.service;

import com.circle.dao.UserMapper;
import com.circle.pojo.User;
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
