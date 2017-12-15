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
    /**
     *
     * 查询出所有的文章列表
     * @return
     */
    public List<Article> listArticle();

    /**
     * 查询出所有的文章和发表文章的用户
     * @param id 文章id
     * @return
     */
    public Article  getArticle(int id);

    /**
     * 查询出文章和相应的评论
     * @param article
     * @return
     */
    public Article getArticleById(Article article);

    /**
     * 根据用户id查询出所有的文章
     * @param id 用户id
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
     * @param id
     */
    public void delete(int id);

    /**
     * 增加评论时，同时更改文章的恢复时间，和评论数
     * @param id
     */
    public void  updateComment(int id);

    /**
     * 增加文章
     * @param article
     */
    public void addArticle(Article article);
}
