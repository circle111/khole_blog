package com.circle.service.impl;

import com.circle.dao.ArticleMapper;
import com.circle.pojo.Article;
import com.circle.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
