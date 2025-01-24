package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {"com.example.demo", "com.speedment.jpastreamer", "com.speedment.jpastreamer.application"})
public class SpringJpaStreamerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaStreamerDemoApplication.class, args);
    }
}
