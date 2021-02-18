package com.circle.controller.home;

import com.circle.dto.ArticleParam;
import com.circle.pojo.Article;
import com.circle.pojo.Type;
import com.circle.service.ArticleService;
import com.circle.service.TypeService;
import com.circle.utils.JSONutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FrontArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private TypeService typeService;
    //获取文章类型信息
    @GetMapping("/default/getTypeInfo")
    public String getTypeInfo() {
        List<Type> typeInfo = typeService.getTypeInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", typeInfo);
        return JSONutil.getJson(map);
    }
    //获取相同类型的文章
    @GetMapping("/default/getArticleListByType/{typeId}")
    public String getArticleByType(@PathVariable("typeId") Integer typeId) {
        List<Article> artList = articleService.getArticleListByType(typeId);
        List<ArticleParam> list = new ArrayList<ArticleParam>();
        for (Article article : artList) {
            ArticleParam articleParam = new ArticleParam();
            articleParam.setId(article.getId());
            articleParam.setType_id(article.getTypeId());
            articleParam.setTitle(article.getTitle());
            articleParam.setIntroduce(article.getIntroduce());
            articleParam.setArticle_content(article.getArticleContent());
            articleParam.setAddTime(article.getAddTime());
            articleParam.setLastTime(article.getLastTime());
            articleParam.setView_count(article.getViewCount());
            articleParam.setTypeName(article.getType().getTypeName());
            list.add(articleParam);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", list);
        return JSONutil.getJson(map);
    }
    //获取文章列表
    @GetMapping("/default/getArticleList")
    public String getArticleList() {
        List<Article> list = articleService.getArticleList();
        List<ArticleParam> resList = new ArrayList<ArticleParam>();
        Map<String, Object> map = new HashMap<String, Object>();
        for (Article article : list) {
            ArticleParam articleParam = new ArticleParam();
            articleParam.setId(article.getId());
            articleParam.setType_id(article.getTypeId());
            articleParam.setTitle(article.getTitle());
            articleParam.setIntroduce(article.getIntroduce());
            articleParam.setArticle_content(article.getArticleContent());
            articleParam.setAddTime(article.getAddTime());
            articleParam.setLastTime(article.getLastTime());
            articleParam.setView_count(article.getViewCount());
            articleParam.setTypeName(article.getType().getTypeName());
            resList.add(articleParam);
        }
        map.put("data", resList);
        return JSONutil.getJson(map);
    }
    //根据文章id获得文章详情，用于修改文章
    @GetMapping("/default/getArticleById/{id}")
    public String getArticleById(@PathVariable("id") Integer id) {
        System.out.println(">The Article only id:" + id);
        Article result = articleService.getArticleById(id);
        Map<String, Object> map = new HashMap<String, Object>();
        ArticleParam articleParam = new ArticleParam();
        articleParam.setId(result.getId());
        articleParam.setType_id(result.getTypeId());
        articleParam.setTypeName(result.getType().getTypeName());
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
