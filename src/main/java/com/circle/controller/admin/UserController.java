package com.circle.controller.admin;

import com.circle.dto.ResponseData;
import com.circle.pojo.User;
import com.circle.service.UserService;
import com.circle.utils.JSONutil;
import com.circle.utils.JWTUtil;
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

    @GetMapping("/admin/index")
    public ResponseData index() {
        return ResponseData.ok();
    }
//@RequestBody Map<String,String> reqmap
    //登录
    @PostMapping("/admin/checkLogin")
    @ResponseBody
    public ResponseData checkLogin(@RequestBody Map<String,String> reqmap){
        String username = reqmap.get("username");
        String password = reqmap.get("password");
        User user = userService.checkLogin(username, password);
//        String username = userReq.getUsername();
//        User user = userService.checkLogin(userReq.getUsername(), userReq.getPassword());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = dateFormat.format(new Date());

        ResponseData responseData = ResponseData.ok();
        if (user != null) {
            String token = JWTUtil.generToken(user.getId()  + "", "Kuroko-Security-Basic", user.getUsername());
            responseData.putDataValue("token", token);
            user.setPassword("******");
            responseData.putDataValue("user", user);
        } else {
            responseData = ResponseData.customerError();
        }
        return responseData;
    }
    //判断是否登录
    @PostMapping("/admin/checkOpenId")
    public String checkOpenId(@RequestBody Map<String,String> reqmap, HttpServletRequest request){
        String cOpenId = reqmap.get("openId");
        String sOpenId = (String) request.getSession().getAttribute("openId");
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
