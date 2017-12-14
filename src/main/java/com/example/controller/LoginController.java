package com.example.controller;

import com.example.dao.RoleMapper;
import com.example.model.Article;
import com.example.model.Privilege;
import com.example.model.Role;
import com.example.service.RoleService;
import com.example.service.UserService;
import com.example.utils.Md5;
import com.example.model.User;
import com.example.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by Kang.Zheng on 2017/11/27.
 */
@Controller
//@RequestMapping("/login")
public class LoginController {
    private  long USE_TIME=86400000;//一天二十四小时
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    /**
     * 登陆进入的途径
     * @return
     */
    @RequestMapping("/hello")
    public  String hello(){

        return "login";
    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    @RequestMapping("/quit")
    public  String quit(HttpServletRequest request){
         request.getSession().removeAttribute("loginInfo");
        return "login";
    }

    /**
     * 跳转到注册页面
     * @return
     */
    @RequestMapping("/registerhello")
    public  String registerHello(){

        return  "register";
    }

    /**
     * 登录操作
     * @param user 登陆的用户
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/login")
    public  String  login(User user, Model model, HttpServletRequest request){

        User user1=userService.findUserByPhone(user);
        Date date=new Date();
     //如果手机号输入错误，在前端显示错误信息
        if(user1==null){
            model.addAttribute("msg","手机号输入错误");
            return "login";
        }
        //userMapper.updateLoginTime(user1);
        //如果用户连续输错三次密码，24小时内禁止登陆
        if(user1.getWorryLogin()>=3){
            if((new Date().getTime()-user1.getLoginTime().getTime())>USE_TIME) {
                user1.setWorryLogin(0);
            }else {
                model.addAttribute("msg", "今日禁止登陆");
                return "login";
            }
        }
        user1.setLoginTime(new Date());
        //判断密码是否正确
        if(Md5.MD5(user.getPassword()).equals(user1.getPassword())){
            user1.setWorryLogin(0);
            userService.updateUser(user1);
            Role r=roleService.getRole(user1.getId());
            user1.setRole(r);
            Role role=roleService.getRoleById(r.getId());
            request.getSession().removeAttribute("edit");
            request.getSession().removeAttribute("delete");
            if(role!=null) {
                //如果登陆成功，删除session已经存在的权限，查询出用户的权限并放到session中
                for (Privilege p : role.getPrivilege()) {
                    if ("edit".equals(p.getPrivilege())){
                        request.getSession().setAttribute("edit",1);
                    }
                     if("delete".equals(p.getPrivilege())) {
                       request.getSession().setAttribute("delete",1);
                    }
                }
            }
            request.getSession().setAttribute("loginInfo",user1);
            return "forward:/article/list";
        }else{
            //密码错误，记录此次错误的次数，并在前端返回错误消息
            user1.setWorryLogin(user1.getWorryLogin()+1);
            userService.updateUser(user1);
            model.addAttribute("msgp","密码错误");

            return "login";
        }

    }
}
