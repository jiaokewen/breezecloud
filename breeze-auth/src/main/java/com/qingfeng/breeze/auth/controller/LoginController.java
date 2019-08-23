package com.qingfeng.breeze.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author qingfeng
 * @description: TODO
 * @date 2019/5/23 17:07
 */
@Controller
public class LoginController {

    @Autowired
    private TokenStore tokenStore;

    @RequestMapping("/login")
    public String hello() {
        //这边我们,默认是返到templates下的login.html
        return "login";
    }

    @GetMapping(value = "/exit")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null) {
            String tokenValue = authHeader.replace("bearer", "").trim();
            OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
            tokenStore.removeAccessToken(accessToken);
        }
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
    }
}
