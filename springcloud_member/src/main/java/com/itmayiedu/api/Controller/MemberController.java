package com.itmayiedu.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author zxp
 * @Date 2020/2/23 0:40
 */
@RestController
public class MemberController {
    @Value("${server.port}")
    private String port;

    // 请求url的数量
    private int reqCount=1;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;


    // 模拟ribbon 轮询取模获取请求的url，RestTemplate请求调用
    @RequestMapping("/ribbonMember")
    public String ribbonMember(){
        String reqUrl=getInstances()+"/getMember";
        System.out.println("请求接口地址 reqUrl:"+reqUrl);
        String result=restTemplate.getForObject(reqUrl,String.class);
        return result;
    }

    // 获取轮寻的请求地址。
    private String getInstances(){
        // 获取eureka注册列表上SpringCloud-member的服务器集合的实例
        List<ServiceInstance> instances= discoveryClient.getInstances("springcloud-member");
        // 如果实例集合为空，则返回
        if(null==instances||instances.size()<=0){
            return  null;
        }
        //获取服务器集群的数量，
        int instancesSize=instances.size();
        // 取模运算
        int serviceIndex= reqCount%instancesSize;
        reqCount++;
        // 获取请求的url
        return instances.get(serviceIndex).getUri().toString();

    }
    @RequestMapping("/getMember")
    public String getMember() {
        System.out.println("进入会员端");
        return "这是会员端,端口号是:"+port;
    }

}
