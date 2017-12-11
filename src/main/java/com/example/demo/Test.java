package com.example.demo;

import com.example.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Kang.Zheng on 2017/11/28.
 */
@Controller

public class Test {
    @Autowired
    private UserMapper userMapper;

    //@Results({@Result()}
    //)
    @RequestMapping("/testtime")

    public String testt() {

        return "register";


    }

    @RequestMapping("/testlogin")

    public String test() {

        return "index";


    }
}