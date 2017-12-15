package com.example.model;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Kang.Zheng on 2017/12/11.
 */
public class Role implements Serializable{
    private int id;//主键
    private List<Privilege> privilege=new ArrayList<>();//角色拥有的权限

    private String roleName;//角色名称
    private List<User> users;//角色对应得用户

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Privilege> getPrivilege() {
        return privilege;
    }

    public void setPrivilege(List<Privilege> privilege) {
        this.privilege = privilege;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
