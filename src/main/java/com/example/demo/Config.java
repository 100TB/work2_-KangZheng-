package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Kang.Zheng on 2017/12/11.
 */
@MapperScan("com.example.dao")
@ComponentScan("com.example")
@Configuration
public class Config {
}
