package com.example.dao;

import com.example.model.Role;

import java.util.List;
import java.util.Map;

/**
 * Created by Kang.Zheng on 2017/12/12.
 */
public interface RoleMapper {

    public List<Role> listRole();
    public Role getRoleById(int  id);
    public void addRole(Role role);
    public  void updatePeivilege(Map map);
}
