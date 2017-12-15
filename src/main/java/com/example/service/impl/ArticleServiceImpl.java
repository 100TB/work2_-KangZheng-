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
    /**
     * 获取全部文章的方法
     */
    public List<Article> listArticle() {
        return articleMapper.listArticle();
    }

    /**
     * 获取文章的内容和评论
     * @param id
     * @return
     */
    public  Article  getArticleAndComments(int id){
        Article article=articleMapper.getArticle(id);
        List<Comment> list=commentService.listComment(id);
        if(list!=null){
            article.setComments(list);
        }
        return article;
    }

    /**
     * 根据文章查询出文章内容，同时封装user属性
     * @param id 文章id
     * @return
     */
    public Article  getArticle(int id){
        return  articleMapper.getArticle(id);
    }

    /**
     *
     * 只获取文章
     * @param article
     * @return
     */
    @Override
    public Article getArticleById(Article article) {
        return articleMapper.getArticleById(article);
    }

    /**
     * 根据用户id查询出用户发出的文章列表
     * @param id
     * @return
     */
    @Override
    public List<Article> getListByid(int id){
        return articleMapper.getListByid(id);
    }

    /**
     * 修改文章
     * @param article
     */
    @Override
    public void edit(Article article) {
        articleMapper.edit(article);
    }

    /**
     * 删除文章
     * @param id
     */
    @Override
    public void delete(int id) {
          articleMapper.delete(id);
    }

    /**
     * 增加评论时，改变文章的回复数量和最后回复时间
     * @param id 文章的id
     */
    public void updateComment(int id) {
        articleMapper.updateComment(id);
    }

    /**
     * 增加文章
     * @param article 文章实体
     */
    @Override
    public void addArticle(Article article) {
        articleMapper.addArticle(article);
    }
}
