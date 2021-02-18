package com.circle.controller.admin;

import com.circle.dto.ArticleParam;
import com.circle.pojo.Article;
import com.circle.pojo.Type;
import com.circle.service.ArticleService;
import com.circle.service.TypeService;
import com.circle.utils.JSONutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private TypeService typeService;
    //增加文章
    @PostMapping("/admin/addArticle")
    public String addArticle(@RequestBody ArticleParam articleParam) {
        System.out.println(">SendData:" + articleParam.toString());
        Article article = new Article();
        boolean res = false;
        Map<String, Object> map = new HashMap<String, Object>();
        article.setTypeId(articleParam.getType_id());
        article.setTitle(articleParam.getTitle());
        article.setIntroduce(articleParam.getIntroduce());
        article.setArticleContent(articleParam.getArticle_content());
        article.setAddTime(articleParam.getAddTime());
        article.setLastTime(articleParam.getLastTime());
        article.setViewCount(articleParam.getView_count());
        System.out.println(">Be insert data:" + article);
        res = articleService.addArticle(article);
        map.put("isSuccess", res);
        if (res) map.put("insertId", 1);
        else map.put("insertId", 2);
        return JSONutil.getJson(map);
    }
    //删除文章
    @RequestMapping("/admin/delArticle/{id}")
    public String deleteArticle(@PathVariable int id) {
        boolean res = articleService.deleteArticle(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", res);
        return JSONutil.getJson(map);
    }
    //修改文章
    @PostMapping("/admin/updateArticle")
    public String updateArticle(@RequestBody ArticleParam articleParam) {
        System.out.println(">AcceptData:" + articleParam.toString());
        Article article = new Article();
        boolean res = false;
        Map<String, Object> map = new HashMap<String, Object>();
        article.setId(articleParam.getId());
        article.setTypeId(articleParam.getType_id());
        article.setTitle(articleParam.getTitle());
        article.setIntroduce(articleParam.getIntroduce());
        article.setArticleContent(articleParam.getArticle_content());
        article.setAddTime(articleParam.getAddTime());
        article.setLastTime(articleParam.getLastTime());
        article.setViewCount(articleParam.getView_count());
        System.out.println(">Be update data:" + article);
        res = articleService.updateArticle(article);
        map.put("isSuccess", res);
        return JSONutil.getJson(map);
    }
    //获取文章类型信息
    @GetMapping("/admin/getTypeInfo")
    public String getTypeInfo() {
        List<Type> typeInfo = typeService.getTypeInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", typeInfo);
        return JSONutil.getJson(map);
    }
    //获取文章列表
    @GetMapping("/admin/getArticleList")
    public String getArticleList() {
        List<Article> resList = articleService.getArticleList();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", resList);
        return JSONutil.getJson(map);
    }
    //根据文章id获得文章详情，用于修改文章
    @GetMapping("/admin/getArticleById/{id}")
    public String getArticleById(@PathVariable("id") Integer id) {
        System.out.println(">The Article only id:" + id);
        Article result = articleService.getArticleById(id);
        Map<String, Object> map = new HashMap<String, Object>();
        ArticleParam articleParam = new ArticleParam();
        articleParam.setId(result.getId());
        articleParam.setType_id(result.getTypeId());
        articleParam.setTitle(result.getTitle());
        articleParam.setIntroduce(result.getIntroduce());
        articleParam.setArticle_content(result.getArticleContent());
        articleParam.setAddTime(result.getAddTime());
        articleParam.setLastTime(result.getLastTime());
        articleParam.setView_count(result.getViewCount());
        map.put("data", articleParam);
        return JSONutil.getJson(map);
    }
}
