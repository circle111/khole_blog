package com.circle.controller;

import com.circle.pojo.User;
import com.circle.service.UserService;
import com.circle.utils.JSONutil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired(required = false)
    private UserService userService;
    //登录
    @PostMapping("/admin/checkLogin")
    public String checkLogin(HttpServletRequest request, HttpServletResponse response){
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        User user = userService.checkLogin(userName, password);
        Map<String, Object> map = new HashMap<String, Object>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = dateFormat.format(new Date());
        if (user != null) {
            request.getSession().setAttribute("openId", date);
            request.getSession().setAttribute("isNew", false);
            map.put("data", "登录成功");
            map.put("openId", date);
        } else {
            map.put("data", "登录失败");
        }
        return JSONutil.getJson(map);
    }
    //判断是否登录
    @PostMapping("/admin/checkOpenId")
    public String checkOpenId(HttpServletRequest request){
        String cOpenId = request.getParameter("openId");
        String sOpenId = (String) request.getSession().getAttribute("openId");
        System.out.println("检查openId是否一致\ncOpenId:" + cOpenId + "\nsOpenId:" + sOpenId);
        Map<String, Object> map = new HashMap<String, Object>();
        if (sOpenId != null && cOpenId.equals(sOpenId)) {
            map.put("data", "已经登录");
        } else {
            map.put("data", "没有登录");
        }
        return JSONutil.getJson(map);
    }
    //推出登录
    @GetMapping("/admin/outLogin")
    public String  outLogin(HttpSession session){
        session.removeAttribute("openId");
        session.invalidate();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", "退出成功");
        return JSONutil.getJson(map);
    }
}
