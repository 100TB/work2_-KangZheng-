package com.example.dao;

import com.example.model.Comment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Kang.Zheng on 2017/12/11.
 */
@Component
public interface CommentMapper {

    /**
     *
     * 根据文章id查询出评论的人，和评论内容
     * @param id 文章主键
     * @return
     */
    public List<Comment> listComment(int id);

    /**
     * 新增评论
     * @param comment
     */
    public void insert(Comment comment);
}
