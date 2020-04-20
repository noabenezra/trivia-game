package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@ComponentScan
@ComponentScan({"com.example.demo.controller"})
public class TriviaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TriviaApplication.class, args);
    }

}
