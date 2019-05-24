package com.qingfeng.breeze.auth.service.impl;

import com.qingfeng.breeze.auth.service.feign.SysUserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author qingfeng
 * @description: TODO
 * @date 2019/5/23 17:42
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserFeign sysUserFeign;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetails user = sysUserFeign.selectByLoginName(s).getData();
        return user;
    }
}
