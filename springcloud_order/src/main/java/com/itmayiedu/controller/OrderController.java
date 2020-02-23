package com.itmayiedu.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author zxp
 * @Date 2020/2/23 12:00
 */
@RestController
public class OrderController {

    /**
     * 在SpringCloud中有两种调用方式:
     * 1.RestTemplate（springboot web组件提供）
     * 2.Feign客户端(SpringCloud自带的)
     */
    @Autowired
    private RestTemplate restTemplate; // 直接引入RestTemplate模板会报错，需要在启动类把 RestTemplate 模板的bean实例加载到该springboot应用中

    //  DiscoveryClient 的使用方法，可以获取已经注册到注册中心的服务列表信息，只需要知道服务的名称即可
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/DiscoveryClientMember")
    public void DiscoveryClientMember(){
        List<ServiceInstance> instances= discoveryClient.getInstances("springcloud-member");
        for (ServiceInstance instance : instances) {
            System.out.println("得到会员的服务的端口号为"+instance.getPort());
        }

    }


    @RequestMapping("/getOrder")
    public  String  getOrder(){
        //两种方式，一种是采用服务别名的方式调用，一种是ip地址直接调用（不建议使用），另外一种是根据服务名字直接调用
        //String result=restTemplate.getForObject("localhost:8001/getMember",String.class);
        String memberUrl = "http://springcloud-member/getMember";
        String result = restTemplate.getForObject(memberUrl, String.class);
        System.out.println("订单服务调用会员服务，"+result);
        return result;
    }



}
