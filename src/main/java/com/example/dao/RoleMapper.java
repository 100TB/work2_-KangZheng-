package com.example.dao;

import com.example.model.Role;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Kang.Zheng on 2017/12/12.
 */
@Component
public interface RoleMapper {

    public List<Role> listRole();
    public Role getRoleById(int  id);
    public void addRole(Role role);
    public  void updatePeivilege(Map map);
    public Role getRole(int id);
}
