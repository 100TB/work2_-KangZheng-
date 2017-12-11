package com.example.service.impl;

import com.example.dao.CommentMapper;
import com.example.model.Comment;
import com.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Kang.Zheng on 2017/12/11.
 */
@Component("commentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> listComment(int id) {
        return commentMapper.listComment(id);
    }

    @Override
    public void addComment(Comment comment) {
        commentMapper.insert(comment);
    }
}
