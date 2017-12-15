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

    /**
     * 根据用户手机号查询用户
     * @param user
     * @return
     */
    public User findUserByPhone(User user);

    /**
     * 根据用户id查询用户
     * @param user
     * @return
     */
    public User findUserById(User user);

    /**
     * 保存用户
     * @param user
     */
    public  void  insert(User user);

    /**
     * 更新用户的登陆次数和登陆时间
     * @param user
     */
    public void updateUser(User user);

    /**
     * 查询全部的用户
     * @return
     */
    public List<User> listUser();

    /**
     *
     * 更改用户的角色
     * @param map 用户主键和角色主键
     */
    public void editRole(Map map);

}
