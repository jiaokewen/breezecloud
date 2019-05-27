package com.qingfeng.breeze.auth.handler;

import com.alibaba.fastjson.JSON;
import com.qingfeng.breeze.api.constants.ResponseConsts;
import com.qingfeng.breeze.api.util.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author qingfeng
 * @description: TODO
 * @date 2019/5/27 18:28
 */
@Component
public class LoginFailHandler implements AuthenticationFailureHandler {

    private static final Logger logger = LoggerFactory.getLogger(LoginFailHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        logger.info("用户:"+httpServletRequest.getParameter("username")+"认证失败");
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        R r = R.fail(ResponseConsts.SUCCESS,"认证失败");
        httpServletResponse.getWriter().write(JSON.toJSONString(r));
    }
}
