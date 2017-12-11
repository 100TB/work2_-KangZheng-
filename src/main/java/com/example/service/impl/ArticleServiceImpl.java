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
}
