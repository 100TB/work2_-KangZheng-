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

    @Override
    public void addRole(Role role) {
        roleMapper.addRole(role);
        int id=role.getId();
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

    @Override
    public Role getRoleById(int id) {
        return  roleMapper.getRoleById(id);
    }

    @Override
    public Role getRole(int id) {
        return roleMapper.getRole(id);
    }
}
