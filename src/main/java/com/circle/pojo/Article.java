package com.circle.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private Integer id;
    private Integer typeId;
    private String title;
    private String articleContent;
    private String introduce;
    private Date addTime;
    private Date lastTime;
    private Integer viewCount;

    private String typeName;
    private String icon;
}
