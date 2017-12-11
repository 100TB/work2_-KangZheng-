package com.example.dao;


import com.example.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

/**
 * Created by Kang.Zheng on 2017/11/27.
 */

public interface UserMapper {

    User findUserByName(User user);
    public  void  insert(User user);
    void updateUser(User user);
    void updateLogin();
    User getTime(User user);
    void updateTime(User user);

}
