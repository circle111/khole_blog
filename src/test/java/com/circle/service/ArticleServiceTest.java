package com.circle.service;

import com.circle.BaseTest;
import com.circle.pojo.Article;
import com.circle.service.impl.ArticleServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class ArticleServiceTest extends BaseTest {
    @Autowired
    private ArticleServiceImpl articleService;
    @Test
    public void addArticle() {
        Article article = new Article();
        article.setTitle("王源");
        article.setTypeId(1);
        article.setArticleContent("asdfasdf");
        article.setViewCount(0);
        boolean res = articleService.addArticle(article);
        System.out.println(res);
    }
    @Test
    @Transactional
    public void deleteArticle(){
        articleService.deleteArticle(47);
        int a = 1/ 0;
        boolean res = articleService.deleteArticle(48);
        System.out.println(res);
    }
}
