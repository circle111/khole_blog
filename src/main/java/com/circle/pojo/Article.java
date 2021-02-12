package com.circle.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private int id;
    private int typeId;
    private String title;
    private String articleContent;
    private String introduce;
    private int addTime;
    private int lastTime;
    private int viewCount;

    private String typeName;
    private String icon;
}
