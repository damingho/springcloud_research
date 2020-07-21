package com.damingho.servicehi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 启动类
 * @Author: Hujm
 * @Date: Created in 10:17 2020/7/21
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }

    @Value( "${server.port}" )
    private String port;

    @GetMapping("hi")
    public String hi() {
        return "hi, port is " + port;
    }
}
