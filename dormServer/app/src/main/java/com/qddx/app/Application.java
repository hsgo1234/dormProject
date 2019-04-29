package com.qddx.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.qddx"})
@MapperScan(basePackages = {"com.qddx"})
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
