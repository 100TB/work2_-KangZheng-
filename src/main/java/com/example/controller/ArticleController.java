package com.example.controller;

import com.example.dao.RoleMapper;
import com.example.model.Article;
import com.example.model.Privilege;
import com.example.model.Role;
import com.example.model.User;
import com.example.service.ArticleService;
import com.example.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by Kang.Zheng on 2017/12/11.
 */


    @Controller
    @RequestMapping(value="article")
    public class ArticleController {
    private static Logger logger = LoggerFactory.getLogger(ArticleController.class);
        @Autowired
        private ArticleService articleService;
       @Autowired
       private RoleService roleService;

    /**
     *
     * @param model
     * @param request
     * @return 判断用户是否登陆，若登陆，跳转到主页，若没有登陆，跳转到首页
     */
        @RequestMapping(value="/list")
        public  String list(Model model, HttpServletRequest request){
           User user= (User)request.getSession().getAttribute("loginInfo");
          if(user==null) {
              logger.info("用户为空");
              return "forward:/hello1";

          }
            Role role=roleService.getRoleById(user.getRole().getId());
            if(role!=null) {
                //若角色id为1，说明是管理员权限，在主页显示所有的用户帖子
                if(role.getId()==1){
                    List<Article> list=articleService.listArticle();
                    model.addAttribute("article",list);
                    return "indexArticle";
                }
            }
            //根据用户id查询出所有的该用户的文章
            List<Article> list=articleService.getListByid(user.getId());
            System.out.println(user.getId());
            model.addAttribute("article",list);
            return "indexArticle";


        }

    /**
     *
     * @param id 文章的id主键
     * @param model
     * @return  查询出文章后跳转到编辑页面
     */
        @RequestMapping(value="/edit/{id}")
        public String edit(@PathVariable("id") int id, Model model){
            Article a=new Article();
            a.setId(id);
            Article a2= articleService.getArticleById(a);
            model.addAttribute("article",a2);
            return "edit";
        }

    /**
     *
     * @param a 需要更新的文章
     * @param model
     * @return 更新完成后，进行跳转
     */
        @RequestMapping(value="/update",method = RequestMethod.POST)
        public String update(Article a, Model model){
            a.setCreated(new Date());
            articleService.edit(a);
            return "forward:/article/list";
        }

    /**
     * 删除文章
     * @param id 文章id
     * @param model
     * @return  跳转到主页
     */
        @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
        public String  delete(@PathVariable("id") int id,Model model){

            articleService.delete(Integer.valueOf(id));
            return "forward:/article/list";

        }

    /**
     * 具有删除权限的人对文章执行删除操作
     * @param id
     * @param model
     * @return 跳转到主页
     */
    @RequestMapping(value="/delete1/{id}",method = RequestMethod.GET)
    public String  delete1(@PathVariable("id") int id,Model model){

        articleService.delete(Integer.valueOf(id));
        return "forward:/hello1";

    }

    /**
     * 返回到增加文章页面
     * @return
     */
        @RequestMapping("/add")
        public String add(){
            return "addArticle";
        }

    /**
     * 执行增加文章的操作
     * @param article
     * @return
     */
    @RequestMapping("/addArticle")
    public String addArticle(Article article){
      logger.info(""+article.getUser().getId());
        articleService.addArticle(article);
        return "forward:/article/list";
    }
    }


