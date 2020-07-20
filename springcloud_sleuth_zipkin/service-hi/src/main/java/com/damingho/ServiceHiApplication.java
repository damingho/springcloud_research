package com.damingho;

import brave.sampler.Sampler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: springboot启动类
 * @Author: Hujm
 * @Date: Created in 9:49 2020/7/20
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
@Slf4j
public class ServiceHiApplication {
    @Autowired
    private RestTemplate restTemplate;

    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }

    @GetMapping("hi")
    public String hi() {
        log.info( "calling trace service-hi" );
        return restTemplate.getForObject( "http://SERVICE-MIYA/miya" , String.class );
    }

    @GetMapping("info")
    public String info() {
        log.info( "calling trace service-hi " );
        return "i'm service-hi";
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
