package com.circle.service;

import com.circle.BaseTest;
import com.circle.pojo.Article;
import com.circle.service.impl.ArticleServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ArticleServiceTest extends BaseTest {
    @Autowired
    private ArticleService articleService;
    @Test
    public void addArticle() {
        Article article = new Article();
        article.setTypeId(1);
        article.setTitle("王源");
        article.setArticleContent("asdfasdf");
        article.setIntroduce("asd");
        article.setAddTime(123);
        article.setLastTime(321);
        article.setViewCount(0);
        boolean res = articleService.addArticle(article);
        System.out.println(res);
    }
    @Test
    public void deleteArticle(){
        boolean res = articleService.deleteArticle(49);
        System.out.println(res);
    }
    @Test
    public void updateArticle() {
        Article article = new Article();
        article.setId(51);
        article.setTypeId(2);
        article.setTitle("王源123");
        article.setArticleContent("asdfasdf123");
        article.setIntroduce("asd123");
        article.setAddTime(123123);
        article.setLastTime(321123);
        article.setViewCount(123);
        boolean res = articleService.updateArticle(article);
        System.out.println(res);
    }
    @Test
    public void getArticleList(){
        List<Article> list = articleService.getArticleList();
        for (Article article : list) {
            System.out.println(article.toString());
        }
    }
    @Test
    public void getArticleById(){
        Article article = articleService.getArticleById(51);
        System.out.println(article);
    }
    @Test
    public void getArticleByType(){
        List<Article> list = articleService.getArticleListByType(2);
        for (Article article : list) {
            System.out.println(article);
        }
    }
}
