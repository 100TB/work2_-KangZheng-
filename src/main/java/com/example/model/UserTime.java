package com.example.model;

import java.util.Date;

/**
 * Created by Kang.Zheng on 2017/11/29.
 */
public class UserTime {

    private int id;//主键
    private String phone;//用户的手机号
    private Date codeTime;//用户获得验证码的时间

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

    public Date getCodeTime() {
        return codeTime;
    }

    public void setCodeTime(Date codeTime) {
        this.codeTime = codeTime;
    }
}
