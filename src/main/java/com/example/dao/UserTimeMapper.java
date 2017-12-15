package com.example.dao;

import com.example.model.UserTime;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Kang.Zheng on 2017/11/29.
 */
@Component
public interface UserTimeMapper {

   /**
    * 保存一条用户发送验证码的时间
    * @param userTime
    */
   public void insert(UserTime userTime);

   /**
    * 更新用户索要验证码的时间
    * @param userTime
    */
   public void update(UserTime userTime);

   /**
    * 获取用户验证码上次发送的时间
    * @param userTime
    * @return
    */
   public UserTime getTime(UserTime userTime);

}
