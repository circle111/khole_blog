package com.circle.service;

import com.circle.BaseTest;
import com.circle.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest extends BaseTest {
    @Autowired
    private UserService userService;
    @Test
    public void checkLogin(){
        User user = userService.checkLogin("admin", "circle");
        System.out.println(user.toString());
    }
}
