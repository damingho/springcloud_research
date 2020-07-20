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
 * @Date: Created in 9:55 2020/7/20
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
@Slf4j
public class ServiceMiyaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceMiyaApplication.class, args);
    }

    @Autowired
    private RestTemplate restTemplate;
    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/hi")
    public String hi() {
        log.info( "hi is being called" );
        return "hi i'm miya";
    }

    @GetMapping("/miya")
    public String info() {
        log.info( "info is being called" );
        return restTemplate.getForObject( "http://SERVICE-HI/info" , String.class );
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

}
