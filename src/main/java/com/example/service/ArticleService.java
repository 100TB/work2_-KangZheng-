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
}
