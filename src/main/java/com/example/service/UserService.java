package com.example.service;

import com.example.model.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Kang.Zheng on 2017/12/12.
 */
public interface UserService {
    public User findUserByPhone(User user);
    public User findUserById(User user);
    public  void  insert(User user);
    public void updateUser(User user);
    public void updateLogin();
    public User getTime(User user);
    public void updateTime(User user);
    public List<User> listUser();
    public void editRole(Map map);

}
