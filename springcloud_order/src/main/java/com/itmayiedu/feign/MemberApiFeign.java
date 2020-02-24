package com.itmayiedu.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * feign客户端,订单服务端 ------调用----> 会员服务端，对应的feign客户端接口,
 * name 表示会员服务端的名字
 */
@FeignClient(name = "springcloud-member")
public interface MemberApiFeign {
    @RequestMapping("/getMember")
    String  getMember();
}
