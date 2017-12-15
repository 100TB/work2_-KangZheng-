package com.example.service.impl;

import com.example.dao.RoleMapper;
import com.example.model.Privilege;
import com.example.model.Role;
import com.example.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kang.Zheng on 2017/12/12.
 */
@Component("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;



    @Override
    public List<Role> listRole() {
        return roleMapper.listRole();
    }

    /**
     * 增加角色
     * @param role 角色实体
     */
    @Override
    public void addRole(Role role) {
        //保存角色
        roleMapper.addRole(role);
        int id=role.getId();
        //查询角色是否拥有权限，若有权限，保存权限
        if(role.getPrivilege()!=null) {
            for (Privilege p : role.getPrivilege()
                    ) {
                Map map = new HashMap<String, Integer>();
                map.put("roleId", id);
                map.put("privilegeId", p.getId());
                roleMapper.updatePeivilege(map);
            }
        }
    }

    /**
     * 根据id获取角色，并且获取角色的权限
     * @param id 角色id
     * @return
     */
    @Override
    public Role getRoleById(int id) {
        return  roleMapper.getRoleById(id);
    }

    /**
     *  根据用户的id获取角色
     * @param id 用户id
     * @return
     */
    @Override
    public Role getRole(int id) {
        return roleMapper.getRole(id);
    }
}
