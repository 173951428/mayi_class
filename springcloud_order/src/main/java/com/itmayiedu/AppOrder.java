package com.itmayiedu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author zxp
 * @Date 2020/2/23 11:55
 */
@SpringBootApplication
@EnableEurekaClient
public class AppOrder {
    public static void main(String[] args) {
        SpringApplication.run(AppOrder.class, args);
    }

    /**
     *  解决RestTemplate找不到的原因，应该把RestTemplate的bean注册到springboot容器中.
     *  其中使用RestTemplate根据服务名字调用的话，必须要加上 @LoadBalanced 注解，实现负载均衡，不然启动会报异常
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
