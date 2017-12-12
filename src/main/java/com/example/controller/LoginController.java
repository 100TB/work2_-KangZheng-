package com.example.controller;

import com.example.utils.Md5;
import com.example.model.User;
import com.example.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Kang.Zheng on 2017/11/27.
 */
@Controller
//@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/hello")
    public  String hello(){

        return "login";
    }
    @RequestMapping("/registerhello")
    public  String registerHello(){

        return  "register";
    }
    @RequestMapping("/login")
    public  String  login(User user, Model model, HttpServletRequest request){

        System.out.println(user.getPhone());
        User user1=userMapper.findUserByName(user);
        Date date=new Date();

        System.out.println(user1);
        if(user1==null){
            model.addAttribute("msg","手机号输入错误");
            return "login";
        }
        //userMapper.updateLoginTime(user1);
        if(user1.getWorryLogin()>=3){
            if((new Date().getTime()-user1.getLoginTime().getTime())>1000*60*60*24) {
                user1.setWorryLogin(0);
            }else {
                model.addAttribute("msg", "今日禁止登陆");
                return "login";
            }
        }
        user1.setLoginTime(new Date());
        System.out.println(Md5.MD5(user.getPassword()));
        System.out.println(user1.getPassword());
        if(Md5.MD5(user.getPassword()).equals(user1.getPassword())){
            user1.setWorryLogin(0);
            userMapper.updateUser(user1);
            //dddd
            request.getSession().setAttribute("loginInfo",user1);
            return "listArticle";
        }else{
            user1.setWorryLogin(user1.getWorryLogin()+1);
            userMapper.updateUser(user1);
            model.addAttribute("msgp","密码错误");

            return "login";
        }

    }
}
