package com.circle.controller.admin;

import com.circle.pojo.User;
import com.circle.service.UserService;
import com.circle.utils.JSONutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public String checkLogin(@RequestBody Map<String,String> reqmap, HttpServletRequest request){
        System.out.println(reqmap.keySet());
        System.out.println(reqmap.size());
        String userName = reqmap.get("userName");
        String password = reqmap.get("password");
        User user = userService.checkLogin(userName, password);
        Map<String, Object> map = new HashMap<String, Object>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = dateFormat.format(new Date());
        System.out.println(">date:"+date+"\n用户名："+userName+"\n密码：" + password);
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
    public String checkOpenId(@RequestBody Map<String,String> reqmap, HttpServletRequest request){
        String cOpenId = reqmap.get("openId");
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
