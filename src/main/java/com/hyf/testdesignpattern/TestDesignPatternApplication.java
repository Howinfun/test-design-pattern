package com.hyf.testdesignpattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class TestDesignPatternApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestDesignPatternApplication.class, args);
    }

}
