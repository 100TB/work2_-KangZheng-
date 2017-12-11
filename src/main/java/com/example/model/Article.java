package com.example.model;

import java.util.Date;
import java.util.List;

/**
 * Created by Kang.Zheng on 2017/12/11.
 */
public class Article {
    private int id;
    private String title;
    private String content;
    private Date created;
    private User user;
    private Date lastReply;
    private int allReply;
    private List<Comment> comments;

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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getLastReply() {
        return lastReply;
    }

    public void setLastReply(Date lastReply) {
        this.lastReply = lastReply;
    }

    public int getAllReply() {
        return allReply;
    }

    public void setAllReply(int allReply) {
        this.allReply = allReply;
    }
}
