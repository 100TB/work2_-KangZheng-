package com.example.dao;

import com.example.model.Article;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Kang.Zheng on 2017/12/11.
 */
@Component
public interface ArticleMapper {
    public List<Article> listArticle();
    public Article  getArticle(int id);
    public Article getArticleById(Article article);
    public List<Article> getListByid(int id);
   public  void edit(Article article);
    public void delete(int id);
   public void  updateComment(int id);
    public void addArticle(Article article);
}
