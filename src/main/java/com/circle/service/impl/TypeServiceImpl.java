package com.circle.service.impl;

import com.circle.dao.TypeMapper;
import com.circle.pojo.Type;
import com.circle.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;
    public List<Type> getTypeInfo() {
        return typeMapper.getTypeInfo();
    }
}
