package com.itmayiedu.api.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zxp
 * @Date 2020/2/23 0:40
 */
@RestController
public class MemberController {
    @Value("${server.port}")
    private String port;
    @RequestMapping("/getMember")
    public String getMember() {
        return "这是会员端,端口号是:"+port;
    }

}
