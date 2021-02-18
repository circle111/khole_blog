package com.circle.controller.admin;

import com.circle.dto.ArticleParam;
import com.circle.pojo.Article;
import com.circle.pojo.Type;
import com.circle.service.ArticleService;
import com.circle.service.TypeService;
import com.circle.utils.JSONutil;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
    public String addArticle(ArticleParam articleParam) {
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
        res = articleService.addArticle(article);
        map.put("isSuccess", res);
        map.put("insertId", 1);
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
    //获取文章类型信息
    @GetMapping("/admin/getTypeInfo")
    public String getTypeInfo() {
        List<Type> typeInfo = typeService.getTypeInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", typeInfo);
        return JSONutil.getJson(map);
    }
}
