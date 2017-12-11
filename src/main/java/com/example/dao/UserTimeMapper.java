package com.example.dao;

import com.example.model.UserTime;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by Kang.Zheng on 2017/11/29.
 */
public interface UserTimeMapper {

    void insert(UserTime userTime);
    void update(UserTime userTime);
    UserTime getTime(UserTime userTime);
}
