package com.qingfeng.breeze.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author qingfeng
 * @description: TODO
 * @date 2019/5/23 17:07
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String hello() {
        //这边我们,默认是返到templates下的login.html
        return "login";
    }
}
