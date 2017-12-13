package com.example.controller;

import com.example.model.Privilege;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 进入到admin页面
     * @param model
     * @return
     */
    @RequestMapping("/admin")
    public String admin(Model model){
        List<User> list=userService.listUser();
        model.addAttribute("user",list);
        return  "admin";
    }

    /**
     *
     * @param id 要修改角色的用户的id
     * @param model
     * @return 跳转到修改角色页面
     */
    @RequestMapping("/editRole/{id}")
    public String editRole(@PathVariable("id") int id, Model model){
       List<Role> list=roleService.listRole();
        model.addAttribute("role",list);
        User user=new User();
        user.setId(id);
        User user1=userService.findUserById(user);
        model.addAttribute("user",user1);
        return "editRole";
    }

    /**
     *
     * @param roleId 角色的id
     * @param userId  用户的id
     * @return  跳转到管理员页面
     */
    @RequestMapping("/edit")
    public String  edit(String roleId,String userId){
       Map map=new HashMap<String,Integer>();
        map.put("userId",userId);
        map.put("roleId",roleId);
        userService.editRole(map);
        return  "forward:/admin/admin";
    }

    /**
     *
     * @param model
     * @return 跳转到新增角色页面
     */
    @RequestMapping("/add")
    public String add(Model model){
        Role r=roleService.getRoleById(1);
        return  "addRole";
    }

    /**
     *
     * @param privilege 新增角色所有的权限的id
     * @param roleName 新增角色的名字
     * @return 返回到管理员页面
     */
    @RequestMapping("/addRole")
    public String addRoleRole(int[] privilege,String roleName){
        Role role=new Role();
        role.setRoleName(roleName);
         for(int i:privilege){
             Privilege p=new Privilege();
             p.setId(i);
             role.getPrivilege().add(p);
         }
        roleService.addRole(role);
        return  "forward:/admin/admin";
    }
}
