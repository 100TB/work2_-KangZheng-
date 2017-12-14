package com.example.controller;

import com.example.service.UserService;
import com.example.utils.Md5;
import com.example.model.User;
import com.example.dao.UserMapper;
import com.example.model.UserTime;
import com.example.dao.UserTimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Kang.Zheng on 2017/11/27.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private UserTimeMapper userTimeMapper;
    @Autowired
    private UserService userService;
    @RequestMapping("/hello")
public  String hello(){
        return  "register";
}

    /**
     * 发送验证码
     * @param httpSession
     * @param userTime 用户上次获取验证码的时间
     * @return
     */
    @RequestMapping("/sendNumber")
@ResponseBody
public Map sendNumber(HttpSession httpSession,UserTime userTime){
    Map map=new HashMap<String,String>();
    UserTime userTime1=userTimeMapper.getTime(userTime);
    if(userTime1!=null) {
        //判断用户距离上次获取验证码是否经过了60秒，如果不够60秒，返回错误信息
        if (new Date().getTime() - userTime1.getCodeTime().getTime() < 60000) {
            map.put("number", 3);
            return map;
        }
    }else{
        //记录此次获取验证码的时间
        userTime.setCodeTime(new Date());
        userTimeMapper.insert(userTime);
    }
    //随机产生4位的验证码
    map.put("number",null);
    Random random = new Random();
    String fourRandom = random.nextInt(10000) + "";
    int randLength = fourRandom.length();
    if(randLength<4){
        for(int i=1; i<=4-randLength; i++)
            fourRandom = "0" + fourRandom  ;
    }
   userTime.setCodeTime(new Date());
    userTimeMapper.update(userTime);
    System.out.println(fourRandom);
    httpSession.setAttribute("number",fourRandom);
    map.put("number",1);
 return map;

}

    /**
     * 检查验证码
     * @param number 用户输入的验证码
     * @param session
     * @param user 用户
     * @return
     */
    @RequestMapping("/checkNm")
@ResponseBody
public Map checkNM(String number,HttpSession session,UserTime user){
    Map map=new HashMap<String,String>();
    map.put("numbercode",null);
  UserTime userTime= userTimeMapper.getTime(user);
    if(userTime!=null){
    if(new Date().getTime()-userTime.getCodeTime().getTime()>60000){
        map.put("numbercode",3);
        return map;
    }}
        //将验证码输入到前台
    System.out.println(number+"验证码"+session.getAttribute("number"));
    if(number.equals(session.getAttribute("number"))) {

        map.put("numbercode", 1);
    }
    return map;


}

    /**
     * 注册
     * @param user 用户
     * @return
     */
    @RequestMapping("/register")
@ResponseBody
public Map ajax(User user){
    Map map=new HashMap<String,String>();
    map.put("status",null);
    if(userService.findUserByPhone(user)!=null){
        map.put("status","3");
        return map;
    }
    //对密码进行MD5加密
    String password= Md5.MD5(user.getPassword());
    Date date=new Date();
    user.setPassword(password);
    user.setLoginTime(date);
    userService.insert(user);
    map.put("status",1);
    return  map;
}

    @RequestMapping("/ajax")
    @ResponseBody
    public Map login(User user){
        Map map=new HashMap<String,String>();
    map.put("code",null);
    if(userService.findUserByPhone(user)!=null){
    map.put("code",1);
}
return map;
}


}
