package com.qingfeng.breeze.auth.handler;

import com.alibaba.fastjson.JSON;
import com.qingfeng.breeze.api.constants.ResponseConsts;
import com.qingfeng.breeze.api.util.R;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author qingfeng
 * @description: 退出登录处理
 * @date 2019/6/5 10:48
 */
@Component
public class LogoutHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.sendRedirect("http://localhost:4000/api/exit");
    }
}
