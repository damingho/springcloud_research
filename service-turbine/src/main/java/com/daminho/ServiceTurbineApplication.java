package com.daminho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @Description: springboot启动类
 * @Author: Hujm
 * @Date: Created in 17:17 2020/7/17
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard
@EnableTurbine
public class ServiceTurbineApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceTurbineApplication.class, args);
    }
}
