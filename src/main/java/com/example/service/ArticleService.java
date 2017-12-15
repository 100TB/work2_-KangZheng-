package com.example.service;

import com.example.model.Article;

import java.util.List;

/**
 * Created by Kang.Zheng on 2017/12/11.
 */
public interface ArticleService {
    /**
     * 获取全部的文章
     * @return
     */
    public List<Article> listArticle();

    /**
     * 获取文章和对应的评论
     * @param id 文章的id
     * @return
     */
    public  Article  getArticleAndComments(int id);

    /**
     * 根据文章查询出文章内容，同时封装user属性
     * @param id 文章id
     * @return
     */
    public Article  getArticle(int id);

    /**
     *
     * 只获取文章
     * @param article
     * @return
     */
    public Article getArticleById(Article article);

    /**
     * 根据用户id查询出用户发出的文章列表
     * @param id
     * @return
     */
    public List<Article> getListByid(int id);

    /**
     * 修改文章
     * @param article
     */
    public void edit(Article article);

    /**
     * 删除文章
     * @param id 文章id
     */
    public void delete(int id);

    /**
     * 增加评论时，改变文章的回复数量和最后回复时间
     * @param id 文章的id
     */
    public void updateComment(int id);

    /**
     * 增加文章
     * @param article
     */
    public void addArticle(Article article);
}
