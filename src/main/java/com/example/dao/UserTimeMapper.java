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

   public void insert(UserTime userTime);
   public void update(UserTime userTime);
    public UserTime getTime(UserTime userTime);

}
