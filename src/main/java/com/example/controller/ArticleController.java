package com.example.controller;

import com.example.dao.RoleMapper;
import com.example.model.Article;
import com.example.model.Privilege;
import com.example.model.Role;
import com.example.model.User;
import com.example.service.ArticleService;
import com.example.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by Kang.Zheng on 2017/12/11.
 */


    @Controller
    @RequestMapping(value="article")
    public class ArticleController {

        @Autowired
        private ArticleService articleService;
       @Autowired
       private RoleService roleService;

        @RequestMapping(value="/list")
        public  String list(Model model, HttpServletRequest request){
           User user= (User)request.getSession().getAttribute("loginInfo");
            if(user==null){
                return "forward:/hello1";
            }
            Role role=roleService.getRoleById(user.getId());
            for(Privilege p:role.getPrivilege()){
                if("edit".equals(p.getPrivilege())||"delete".equals(p.getPrivilege())){
                    List<Article> list=articleService.listArticle();
                    model.addAttribute("article",list);
                    return "indexArticle";
                }
            }
            List<Article> list=articleService.getListByid(user.getId());
            model.addAttribute("article",list);
            return "indexArticle";

        }
        @RequestMapping(value="/edit/{id}")
        public String edit(@PathVariable("id") int id, Model model){
           Article a=new Article();
            a.setId(id);
            Article a2= articleService.getArticleById(a);
            model.addAttribute("article",a2);
            return "edit";
        }
        @RequestMapping(value="/update",method = RequestMethod.POST)
        public String update(Article a, Model model){
            a.setCreated(new Date());
            articleService.edit(a);
            return "forward:/article/list";
        }
        @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
        public String  delete(@PathVariable("id") int id,Model model){

            articleService.delete(Integer.valueOf(id));
            return "forward:/article/list";

        }

        @RequestMapping("/add")
        public String add(){
            return "addArticle";
        }
    @RequestMapping("/addArticle")
    public String addArticle(Article article){

        articleService.addArticle(article);
        return "addArticle";
    }

    }


