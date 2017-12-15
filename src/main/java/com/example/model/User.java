package com.example.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Kang.Zheng on 2017/12/11.
 */
public class User implements Serializable {
    private  int id;//主键id
    private String  phone;//用户手机号
    private String password;//用户密码
    private int worryLogin;//登陆错误的次数
    private Date loginTime;//登陆的时间
    private List<Article> articles;//发表过的文章
    private List<String> privileges;//权限
    private  Role role;//对应的角色

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<String> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<String> privileges) {
        this.privileges = privileges;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getWorryLogin() {
        return worryLogin;
    }

    public void setWorryLogin(int worryLogin) {
        this.worryLogin = worryLogin;
    }


    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
