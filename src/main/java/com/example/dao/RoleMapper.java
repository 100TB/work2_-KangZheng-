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

    /**
     * 获取所有的角色
     * @return
     */
    public List<Role> listRole();

    /***
     * 根据角色id获取角色名称和角色的权限
     * @param id
     * @return
     */
    public Role getRoleById(int  id);

    /**
     * 增加角色
     * @param role
     */
    public void addRole(Role role);

    /**
     * 更新角色的权限
     * @param map 角色主键和权限主键
     */
    public  void updatePeivilege(Map map);

    /**
     * 根据角色id获取角色名称
     * @param id 角色id
     * @return
     */
    public Role getRole(int id);
}
