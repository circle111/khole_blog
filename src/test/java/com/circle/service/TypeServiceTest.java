package com.circle.service;

import com.circle.BaseTest;
import com.circle.pojo.Type;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TypeServiceTest extends BaseTest {
    @Autowired
    private TypeService typeService;
    @Test
    public void getTypeInfo() {
        List<Type> list = typeService.getTypeInfo();
        for (Type type : list) {
            System.out.println(type);
        }
    }
}
