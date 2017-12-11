package com.example.service;

import com.example.model.Comment;

import java.util.List;

/**
 * Created by Kang.Zheng on 2017/12/11.
 */
public interface CommentService {

    public List<Comment> listComment(int id);
    public void addComment(Comment comment);


}
