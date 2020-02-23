package com.itmayiedu.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

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

}
