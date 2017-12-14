package com.example.demo;

import com.example.utils.Md5;
import com.example.model.User;
import com.example.dao.UserMapper;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kang.Zheng on 2017/11/27.
 */
@Controller
@RequestMapping("/re")
public class JavaConfig {
    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @Autowired
    private UserMapper userMapper;
    Map map=new HashMap<String,String>();



    @RequestMapping(value="/login1")
    @ResponseBody
    public String  insert(@Valid User user, Model model, BindingResult result) {
        user.setPassword(Md5.MD5(user.getPassword()));
        userMapper.insert(user);
        return "login";
    }

    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse
            httpServletResponse) throws Exception{
      byte[] captchaChallengeAsJpeg = null;
           ByteArrayOutputStream
                   jpegOutputStream = new ByteArrayOutputStream();
              try {
             //生产验证码字符串并保存到session中
                 String createText = defaultKaptcha.createText();
            httpServletRequest.getSession().setAttribute("vrifyCode", createText);
                  //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
                BufferedImage challenge = defaultKaptcha.createImage(createText);
             ImageIO.write(challenge, "jpg", jpegOutputStream);
                    } catch (IllegalArgumentException e) {
                       httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
                     return;
                 }

                //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
             captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
               httpServletResponse.setHeader("Cache-Control", "no-store");
               httpServletResponse.setHeader("Pragma", "no-cache");
                   httpServletResponse.setDateHeader("Expires", 0);
                httpServletResponse.setContentType("image/jpeg");
             ServletOutputStream responseOutputStream =
                            httpServletResponse.getOutputStream();
            responseOutputStream.write(captchaChallengeAsJpeg);
            responseOutputStream.flush();
                responseOutputStream.close();
        }
    @RequestMapping("/imgvrifyControllerDefaultKaptcha")
    @ResponseBody
public Map imgvrifyControllerDefaultKaptcha(String yanzhengma, HttpSession session){
        map.put("info",null);
           String captchaId = (String) session.getAttribute("vrifyCode");

       System.out.println("Session  vrifyCode "+captchaId+" form vrifyCode "+yanzhengma);

    if (captchaId.equals(yanzhengma)) {
            map.put("info", 1);

           } else {
               map.put("info", 0);


        }
      return map;
   }


}
