package com.example.service;

import com.example.model.User;

import java.util.List;

/**
 * Created by Kang.Zheng on 2017/12/12.
 */
public interface UserService {
    User findUserByName(User user);
    User findUserById(User user);
    public  void  insert(User user);
    void updateUser(User user);
    void updateLogin();
    User getTime(User user);
    void updateTime(User user);
    public List<User> listUser();

}
