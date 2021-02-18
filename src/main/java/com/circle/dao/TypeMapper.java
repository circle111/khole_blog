package com.circle.dao;

import com.circle.pojo.Type;

import java.util.List;

public interface TypeMapper {
    //查询所有的文章类型
    public List<Type> getTypeInfo();
}
