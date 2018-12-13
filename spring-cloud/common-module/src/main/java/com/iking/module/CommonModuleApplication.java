package com.iking.module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CommonModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonModuleApplication.class, args);
    }
}
