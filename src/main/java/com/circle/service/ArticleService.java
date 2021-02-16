package com.circle.service;

import com.circle.pojo.Article;

public interface ArticleService {
    //添加文章
    public boolean addArticle(Article article);
    //删除文章
    public boolean deleteArticle(Integer id);
}
