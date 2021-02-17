package com.circle.service;

import com.circle.pojo.Article;
import com.circle.pojo.Type;

import java.util.List;

public interface ArticleService {
    //添加文章
    public boolean addArticle(Article article);
    //删除文章
    public boolean deleteArticle(Integer id);
    //修改文章
    public boolean updateArticle(Article article);
    //获取所有的文章类型
    public List<Type> getTypeInfo();
    //获取所有的文章
    public List<Article> getArticleList();
    //通过文章id获取
    public Article getArticleById(Integer id);
    //获取相同类型的文章
    public List<Article> getArticleListByType(Integer typeId);
}
