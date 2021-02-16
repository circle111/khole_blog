package com.circle.service;

import com.circle.BaseTest;
import com.circle.pojo.Article;
import com.circle.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        int res = articleService.addArticle(article);
        System.out.println(res);
    }
}
