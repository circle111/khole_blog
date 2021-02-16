package com.circle.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type {
    private Integer id;
    private String typeName;
    private Integer orderNum;
    private String icon;
}
