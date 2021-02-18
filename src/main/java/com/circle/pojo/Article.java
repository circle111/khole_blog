package com.circle.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private Integer id;
    private Integer typeId;
    private String title;
    private String articleContent;
    private String introduce;
    private String addTime;
    private String lastTime;
    private Integer viewCount;

    private Type type;
}
