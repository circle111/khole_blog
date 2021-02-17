package com.circle.service.impl;

import com.circle.dao.ArticleMapper;
import com.circle.pojo.Article;
import com.circle.pojo.Type;
import com.circle.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    public boolean addArticle(Article article) {
        return articleMapper.addArticle(article) > 0;
    }
    public boolean deleteArticle(Integer id) {
        return articleMapper.deleteArticle(id) > 0;
    }
    public boolean updateArticle(Article article) {
        return articleMapper.updateArticle(article) > 0;
    }
    public List<Type> getTypeInfo() {
        return articleMapper.getTypeInfo();
    }
    public List<Article> getArticleList() {
        return articleMapper.getArticleList();
    }

    public Article getArticleById(Integer id) {
        return articleMapper.getArticleById(id);
    }

    public List<Article> getArticleListByType(Integer typeId) {
        return articleMapper.getArticleListByType(typeId);
    }
}
