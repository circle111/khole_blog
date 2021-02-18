package com.circle.dto;

import lombok.Data;

@Data
public class ArticleParam {
    private Integer id;
    private Integer type_id;
    private String title;
    private String article_content;
    private String introduce;
    private String addTime;
    private String lastTime;
    private Integer view_count;
    private String typeName;
}
