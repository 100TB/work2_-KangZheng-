package com.example.service.impl;

import com.example.dao.UserMapper;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Kang.Zheng on 2017/12/12.
 */
@Component("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User findUserByPhone(User user){
        return userMapper.findUserByPhone(user);
    }

    /**
     * 新增用户
     * @param user
     */
    public  void  insert(User user){
        userMapper.insert(user);
    }

    /**
     * 更新用户的登陆错误次数和时间
     * @param user
     */
    public void updateUser(User user){
       userMapper.updateUser(user);
    }



    /**
     * 浏览用户
     * @return
     */
    public List<User> listUser(){
        return  userMapper.listUser();
    }

    /**
     * 更改用户的角色
     * @param map
     */
    @Override
    public void editRole(Map map) {
        userMapper.editRole(map);
    }

    /**
     * 根据用户的id查找用户
     * @param user
     * @return
     */
    public User findUserById(User user){
        return userMapper.findUserById(user);
    }

}
