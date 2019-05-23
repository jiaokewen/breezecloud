package com.qingfeng.breeze.auth.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.*;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @author qingfeng
 * @description: feign拦截器，在请求头添加token
 * @date 2019/5/21 9:24
 */
@Configuration
public class FeignHeadersInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        if (null == getHttpServletRequest()) {
            // 此处省略日志记录
            return;
        }
        // 将获取Token对应的值往下面传
        Map<String, String> headersMap = getHeaders(getHttpServletRequest());
        if (headersMap != null && headersMap.size() > 0) {
            Set<Entry<String, String>> entrySet = headersMap.entrySet();
            for (Entry<String, String> entry : entrySet) {
                String key = entry.getKey();
                String value = entry.getValue();
                // Authorization //headersMap.get("Authorization")
                requestTemplate.header(key, value);
            }

        }

    }

    private HttpServletRequest getHttpServletRequest() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Feign拦截器拦截请求获取Token对应的值
     *
     * @param request
     * @return
     */
    private Map<String, String> getHeaders(HttpServletRequest request) {
        Map<String, String> map = new LinkedHashMap<>();
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }
}
