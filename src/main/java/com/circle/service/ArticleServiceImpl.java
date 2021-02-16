package com.circle.service;

import com.circle.dao.ArticleMapper;
import com.circle.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    public int addArticle(Article article) {
        return articleMapper.addArticle(article);
    }
}
