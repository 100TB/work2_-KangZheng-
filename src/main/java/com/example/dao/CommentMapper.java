package com.example.dao;

import com.example.model.Comment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Kang.Zheng on 2017/12/11.
 */
@Component
public interface CommentMapper {

    public List<Comment> listComment(int id);
    public void insert(Comment comment);
}
