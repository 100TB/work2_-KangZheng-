package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

/**
 * Created by Kang.Zheng on 2017/12/11.
 */
public class ArticleController {

 /*
    @Controller
    @RequestMapping(value="message")
    public class MessageAction {

        @Autowired
        private MessageMapper messageMapper;

        @RequestMapping(value="/list")
        public  String list(Model model){

            List<RegisterController> list= messageMapper.getList();
            model.addAttribute("message",list);
            return "messageList";

        }
        @RequestMapping(value="/edit/{id}")
        public String edit(@PathVariable("id") int id, Model model){
            RegisterController m=new RegisterController();
            m.setId(id);
            RegisterController m2= messageMapper.getUserById(m);
            model.addAttribute("message",m2);
            return "edit";
        }
        @RequestMapping(value="/update",method = RequestMethod.POST)
        public String update(RegisterController message, Model model){
            message.setCreateDate(new Date());
            System.out.println("哈哈哈");

            messageMapper.edit(message);
            return "forward:/message/list";
        }
        @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
        public String  delete(@PathVariable("id") int id,Model model){

            messageMapper.delete(Integer.valueOf(id));
            List<RegisterController> list= messageMapper.getList();
            model.addAttribute("message",list);
            return "messageList";

        }


    }
    */

}
