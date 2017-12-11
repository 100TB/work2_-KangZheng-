package com.example.dao;

import com.example.model.Article;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Kang.Zheng on 2017/12/11.
 */
public interface ArticleMapper {
    public List<Article> listArticle();
    public Article  getArticle(int id);
    Article getArticleById(Article article);
    List<Article> getList();
    void edit(Article article);
    void delete(int id);
}
