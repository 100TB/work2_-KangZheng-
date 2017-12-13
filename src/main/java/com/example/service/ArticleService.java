package com.example.service;

import com.example.model.Article;

import java.util.List;

/**
 * Created by Kang.Zheng on 2017/12/11.
 */
public interface ArticleService {

    public List<Article> listArticle();
    public  Article  getArticleAndComments(int id);
    public Article  getArticle(int id);
    public Article getArticleById(Article article);
    public List<Article> getListByid(int id);
    public void edit(Article article);
    public void delete(int id);
    public void updateComment(int id);
    public void addArticle(Article article);
}
