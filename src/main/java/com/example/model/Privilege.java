package com.example.model;

/**
 * Created by Kang.Zheng on 2017/12/12.
 */
public class Privilege{

    private int id;//主键
    private String privilege;//权限名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

}
