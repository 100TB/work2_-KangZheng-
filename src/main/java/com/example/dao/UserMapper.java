package com.example.dao;


import com.example.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Kang.Zheng on 2017/11/27.
 */
@Component
public interface UserMapper {

    public User findUserByName(User user);
    public User findUserById(User user);
    public  void  insert(User user);
    public void updateUser(User user);
    public void updateLogin();
    public User getTime(User user);
    public void updateTime(User user);
    public List<User> listUser();
    public void editRole(Map map);

}
