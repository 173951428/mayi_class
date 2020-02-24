package com.itmayiedu.controller;

import com.itmayiedu.feign.MemberApiFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zxp
 * @Date 2020/2/24 16:57
 */
@RestController
public class FeignController {

    @Autowired
    private MemberApiFeign memberApiFeign;

    @RequestMapping("/feignMember")
    public String feignMember(){
        return  memberApiFeign.getMember();

    }
}
