package com.daminho;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: springboot启动类
 * @Author: Hujm
 * @Date: Created in 17:11 2020/7/17
 * @Version: 1.0
 */
@EnableEurekaClient
@SpringBootApplication
@RestController
@EnableHystrix
@EnableHystrixDashboard
public class ServiceHiApplication {

	/**
	 * 访问地址 http://localhost:8762/actuator/hystrix.stream
	 */

	public static void main(String[] args) {
		SpringApplication.run(ServiceHiApplication.class, args);
	}

	@Value( "${server.port}" )
	private String port;

	@GetMapping("/hi")
	@HystrixCommand(fallbackMethod = "hiError")
	public String hi() {
		return "hello , port is " + port;
	}

	public String hiError() {
		return "hi, server error";
	}

}