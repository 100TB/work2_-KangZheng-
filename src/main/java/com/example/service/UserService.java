package com.example.service;

import com.example.model.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Kang.Zheng on 2017/12/12.
 */
public interface UserService {

    /**
     * 根据用户名查询用户
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
     * 新增一个用户
     * @param user
     */
    public  void  insert(User user);

    /**
     * 更新用户的登陆时间和登陆次数
     * @param user
     */
    public void updateUser(User user);



    /**
     * 查询出所有用户
     * @return
     */
    public List<User> listUser();

    /**
     * 更改用户的角色
     * @param map 用户的主键和角色的主键
     */
    public void editRole(Map map);

}
