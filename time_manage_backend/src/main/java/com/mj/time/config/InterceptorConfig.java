package com.mj.time.config;

import com.mj.time.intercepter.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class InterceptorConfig  implements WebMvcConfigurer {
    @Resource
    TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 设置所有的路径都要进行拦截
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/**");
    }
}