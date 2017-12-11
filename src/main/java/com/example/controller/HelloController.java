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

import java.util.List;

/**
 * Created by Kang.Zheng on 2017/12/11.
 */
@Controller
public class HelloController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;

    @RequestMapping("/hello1")
    public String hello(Model model){
        System.out.println("hello");
        List<Article> list=articleService.listArticle();
        model.addAttribute("list",list);

        return "listArticle";
    }
    @RequestMapping("/hello2/{id}")
    public String hello2(Model model, @PathVariable("id") int id){
        System.out.println(id);
        Article article=articleService.getArticleAndComments(id);
        model.addAttribute("article",article);
        for (Comment c:article.getComments()
             ) {
            System.out.println(c.getContent());
        }
        return  "article";
    }
    @RequestMapping("/hello3")
    public String hello3(Model model, String content,int id,int userId){
        System.out.println(id);
        Article article=new Article();
        article.setId(id);
        User user=new User();
        user.setId(userId);
        Comment comment=new Comment();

        comment.setArticle(article);
        comment.setUser(user);
        comment.setContent(content);
        commentService.addComment(comment);
        System.out.println("测试");
        return  "forward:/hello2/"+id;
    }

}
