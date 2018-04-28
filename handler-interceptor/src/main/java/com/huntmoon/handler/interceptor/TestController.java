package com.huntmoon.handler.interceptor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangtao
 * @since 2018/4/28
 */
@RestController
public class TestController {
    @RequestMapping("test")
    public String  test(){
        return "test";
    }
}
