package com.itmayiedu.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author zxp
 * @Date 2020/2/23 0:32
 */
@SpringBootApplication
@EnableEurekaClient
public class AppMember {
    public static void main(String[] args) {
        SpringApplication.run(AppMember.class, args);
    }
    @Bean
   // @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
