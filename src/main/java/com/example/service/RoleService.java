package com.example.service;

import com.example.model.Role;

import java.util.List;

/**
 * Created by Kang.Zheng on 2017/12/12.
 */
public interface RoleService {
    public List<Role> listRole();
    public void addRole(Role role);
    public Role getRoleById(int  id);
}
