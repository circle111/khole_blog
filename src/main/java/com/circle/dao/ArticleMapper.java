package com.circle.dao;

import com.circle.pojo.Article;
import com.circle.pojo.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {
    //添加文章
    public int addArticle(Article article);
    //删除文章
    public int deleteArticle(@Param("articleId") Integer id);
    //修改文章
    public int updateArticle(Article article);
    //查询所有的文章列表
    public List<Article> getArticleList();
    //根据文章序号查询文章
    public Article getArticleById(Integer id);
    //根据文章类型查询文章列表
    public List<Article> getArticleListByType(Integer type_id);
}
