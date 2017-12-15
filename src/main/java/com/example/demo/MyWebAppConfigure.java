package com.example.demo;

import com.example.interceptor.MyInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Kang.Zheng on 2017/12/11.
 */
@MapperScan("com.example.dao")
@ComponentScan("com.example")
@Configuration
public class MyWebAppConfigure extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器，拦截通完管理员页面的请求
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/admin/*");
        super.addInterceptors(registry);
    }
}
