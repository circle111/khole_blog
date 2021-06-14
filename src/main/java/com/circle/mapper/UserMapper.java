package com.circle.mapper;

import com.circle.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    //判断用户名密码是否正确
    public User checkLogin(@Param("username") String username, @Param("password") String password);
}
