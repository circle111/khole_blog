package com.circle.dto;

import lombok.Data;

@Data
public class ArticleParam {
    private Integer type_id;
    private String title;
    private String article_content;
    private String introduce;
    private Integer addTime;
    private Integer lastTime;
    private Integer view_count;
}
