package com.example.service;

import com.example.model.Comment;

import java.util.List;

/**
 * Created by Kang.Zheng on 2017/12/11.
 */
public interface CommentService {

    /**
     *  根据文章id获取所有的评论和发表评论的人
     * @param id
     * @return
     */
    public List<Comment> listComment(int id);

    /**
     * 增加评论
     * @param comment
     */
    public void addComment(Comment comment);


}
