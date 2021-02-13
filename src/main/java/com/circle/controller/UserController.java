package com.circle.controller;

import com.circle.pojo.User;
import com.circle.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired(required = false)
    @Qualifier("UserServiceImpl")
    private UserService userService;
    @RequestMapping("/admin/checkLogin")
    public String checkLogin(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        User user = userService.checkLogin(userName, password);
        Map<String, Object> map = new HashMap<String, Object>();
        ObjectMapper mapper = new ObjectMapper();
        Date date = new Date();
        if (user != null) {
            request.getSession().setAttribute("openId", date);
            request.getSession().setAttribute("isNew", false);
            map.put("data", "登录成功");
            map.put("openId", date);
            return mapper.writeValueAsString(map);
        }
        map.put("data", "登录失败");
        return mapper.writeValueAsString(map);
    }
}
