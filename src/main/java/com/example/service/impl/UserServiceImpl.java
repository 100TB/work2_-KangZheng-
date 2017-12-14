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
    public  void  insert(User user){
        userMapper.insert(user);
    }
    public void updateUser(User user){
       userMapper.updateUser(user);
    }
    public void updateLogin(){
        userMapper.updateLogin();
    }
    public User getTime(User user){
       return  userMapper.getTime(user);
    }
    public void updateTime(User user){
        userMapper.updateTime(user);
    }
    public List<User> listUser(){
        return  userMapper.listUser();
    }

    @Override
    public void editRole(Map map) {
        userMapper.editRole(map);
    }

    public User findUserById(User user){
        return userMapper.findUserById(user);
    }

}
