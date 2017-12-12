package com.example.service.impl;

import com.example.dao.ArticleMapper;
import com.example.model.Article;
import com.example.model.Comment;
import com.example.service.ArticleService;
import com.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Kang.Zheng on 2017/12/11.
 */
@Component("acticleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private CommentService commentService;
    @Override
    public List<Article> listArticle() {
        return articleMapper.listArticle();
    }

    public  Article  getArticleAndComments(int id){
        Article article=articleMapper.getArticle(id);
        List<Comment> list=commentService.listComment(id);
        if(list!=null){
            article.setComments(list);
        }
        return article;
    }
    public Article  getArticle(int id){
        return  articleMapper.getArticle(id);
    }

    @Override
    public Article getArticleById(Article article) {
        return articleMapper.getArticleById(article);
    }

    @Override
    public List<Article> getListByid(int id){
        return articleMapper.getListByid(id);
    }

    @Override
    public void edit(Article article) {
        articleMapper.edit(article);
    }

    @Override
    public void delete(int id) {
          articleMapper.delete(id);
    }

    public void updateComment(int id) {
        articleMapper.updateComment(id);
    }

    @Override
    public void addArticle(Article article) {
        articleMapper.addArticle(article);
    }
}
