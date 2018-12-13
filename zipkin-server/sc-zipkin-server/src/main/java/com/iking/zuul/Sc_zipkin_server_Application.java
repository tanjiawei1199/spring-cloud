package com.iking.zuul;
/**
 * 微服务跟踪Zipkin Server
 * 此项目启动后访问 http://localhost:9411/ 即可监控微服务之间的调用关系和系统延时等问题
 *
 * @auther: tjw
 * @date: 2018/12/12 15:27
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.EnableZipkinServer;

@EnableEurekaClient
@EnableZipkinServer
@SpringBootApplication
public class Sc_zipkin_server_Application {

    public static void main(String[] args) {
        SpringApplication.run(Sc_zipkin_server_Application.class, args);
    }
}
