package com.mj.time;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan(value = {"com.mj.time.controller"})
@ComponentScan(value = {"com.mj.time.service"})
@ComponentScan(value = {"com.mj.time.util"})
@MapperScan(value = {"com.mj.time.mapper"})
@EnableFeignClients(basePackages = {"com.mj.time.wechat.service"})
public class TimeApplication {
    public static void main(String[] args) {
        SpringApplication.run(TimeApplication.class, args);
    }
}
