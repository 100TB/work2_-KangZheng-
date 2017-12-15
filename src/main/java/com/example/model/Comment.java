package com.example.model;

import java.util.Date;

/**
 * Created by Kang.Zheng on 2017/12/11.
 */
public class Comment {
    private int id;//主键
    private String content;//评论内容
    private Date created;//评论时间
    private User user;//发表评论的用户
    private Article article;//评论的文章

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
