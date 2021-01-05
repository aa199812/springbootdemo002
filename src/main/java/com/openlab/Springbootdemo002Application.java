package com.openlab;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.openlab.dao")
public class Springbootdemo002Application {

    public static void main(String[] args) {
        SpringApplication.run(Springbootdemo002Application.class, args);
    }

}
