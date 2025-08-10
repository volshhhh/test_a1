package com.example.unauthorizeddeliveries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class UnauthorizeddeliveriesApplication {
    public static void main(String[] args) {
        SpringApplication.run(UnauthorizeddeliveriesApplication.class, args);
    }
}