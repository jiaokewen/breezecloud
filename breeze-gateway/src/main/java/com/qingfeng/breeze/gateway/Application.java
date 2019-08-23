package com.qingfeng.breeze.gateway;

import com.qingfeng.breeze.api.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@EnableDiscoveryClient
@EnableZuulProxy
@EnableOAuth2Sso
@RestController
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class Application extends WebSecurityConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private TokenStore tokenStore;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/login", "/breeze-user/**", "/breeze-log/**","/breeze-auth/**")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.csrf()
				.disable();
	}

	@GetMapping(value = "/exit")
	public R exit(HttpServletRequest request, HttpServletResponse response){

		new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
		HttpSession session= request.getSession(false);
		SecurityContextHolder.clearContext();
		session= request.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		for(Cookie cookie : request.getCookies()) {
			cookie.setMaxAge(0);
		}
		return R.success(200,"已退出登录");
	}
}