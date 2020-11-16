package com.mj.time;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.mj.time.controller"})
@ComponentScan(value = {"com.mj.time.service"})
@MapperScan(value = {"com.mj.time.mapper"})
public class TimeApplication {
    public static void main(String[] args) {
        SpringApplication.run(TimeApplication.class, args);
    }
}
