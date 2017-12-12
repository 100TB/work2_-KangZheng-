package com.example.controller;

import com.example.model.Role;
import com.example.model.User;
import com.example.service.RoleService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Kang.Zheng on 2017/12/12.
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/admin")
    public String admin(Model model){
        List<User> list=userService.listUser();
        model.addAttribute("user",list);
        return  "admin";
    }
    @RequestMapping("/editRole/{id}")
    public String editRole(@PathVariable("id") int id, Model model){
       List<Role> list=roleService.listRole();
        model.addAttribute("role",list);
        User user=new User();
        user.setId(id);
        User user1=userService.findUserById(user);
        model.addAttribute("user",user1);
        System.out.println(id);
        System.out.println(user1);
        return "editRole";
    }
    @RequestMapping("/list")
    @ResponseBody
    public Role list(Model model){
        Role r=roleService.getRoleById(1);
        return  r;
    }

}
