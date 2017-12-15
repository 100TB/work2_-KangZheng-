package com.example.service;

import com.example.model.Role;

import java.util.List;

/**
 * Created by Kang.Zheng on 2017/12/12.
 */
public interface RoleService {
    /**
     * 获取所有的角色
     * @return
     */
    public List<Role> listRole();

    /**
     * 增加一个新的角色
     * @param role
     */
    public void addRole(Role role);

    /**
     *
     * 根据角色id获取角色的名称和对应权限
     * @param id 角色主键
     * @return
     */
    public Role getRoleById(int  id);

    /**
     * 根据角色id获取角色的名称
     * @param id 角色主键
     * @return
     */
    public Role getRole(int id);
}
