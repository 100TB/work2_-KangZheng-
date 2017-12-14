package com.example.controller;

import com.example.model.Article;
import com.example.model.Comment;
import com.example.model.User;
import com.example.service.ArticleService;
import com.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kang.Zheng on 2017/12/11.
 */
@Controller
public class CommentController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;

    /**
     * 查出所有的文章，并跳转到前端页面显示
     * @param model
     * @return
     */
    @RequestMapping("/hello1")
    public String hello(Model model){
        List<Article> list=articleService.listArticle();
        model.addAttribute("list",list);

        return "listArticle";
    }

    /**
     * 根据文章id，查出所有的评论
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/hello2/{id}")
    public String hello2(Model model, @PathVariable("id") int id){
        Article article=articleService.getArticleAndComments(id);
        model.addAttribute("article",article);
        return  "article";
    }

    /**
     * 存储一条新评论，并更新article表的评论总数和总后评论时间
     * @param model
     * @param content 新增评论的内容
     * @param id   评论的文章id
     * @param userId 发表评论的用户id
     * @return 返回到文章页面
     */
    @RequestMapping("/hello3")
    public String hello3(Model model, String content,int id,int userId){
        Article article=new Article();
        article.setId(id);
        User user=new User();
        user.setId(userId);
        Comment comment=new Comment();

        comment.setArticle(article);
        comment.setUser(user);
        comment.setContent(content);
        commentService.addComment(comment);
        articleService.updateComment(id);
        return  "forward:/hello2/"+id;
    }

    /**
     * 不具有管理员权限的用户跳转到错误页面
     * @return
     */
    @RequestMapping("/noAdmin")
    public String noAdmin(){
        return "/error";
    }

}
