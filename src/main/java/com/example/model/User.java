package com.example.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Kang.Zheng on 2017/12/11.
 */
public class User implements Serializable {
    private  int id;
    private String  phone;
    private String password;
    private int worryLogin;
    private Date codeTime;
    private Date loginTime;
    private List<Article> articles;
    private List<String> privileges;
    private  Role role;

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

    public Date getCodeTime() {
        return codeTime;
    }

    public void setCodeTime(Date codeTime) {
        this.codeTime = codeTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
