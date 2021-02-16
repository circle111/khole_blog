package com.circle.service;

import com.circle.pojo.User;

public interface UserService {
    //判断用户名密码是否正确
    public User checkLogin(String username, String password);
}
