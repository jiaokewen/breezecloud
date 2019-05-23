package com.qingfeng.breeze.auth.controller;

import com.netflix.discovery.converters.Auto;
import com.qingfeng.breeze.api.util.R;
import com.qingfeng.breeze.auth.model.SysUser;
import com.qingfeng.breeze.auth.service.feign.SysUserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qingfeng
 * @description: TODO
 * @date 2019/5/20 18:15
 */
@RestController
@RequestMapping(value = "/sysUser/")
public class SysUserController {

    @Autowired
    private SysUserFeign sysUserFeign;

    @GetMapping(value = "selectByLoginName")
    public R<SysUser> selectByLoginName (@RequestParam("loginName") String loginName) {
        return sysUserFeign.selectByLoginName(loginName);
    }

    @GetMapping(value = "test")
    public R<SysUser> test () {
        return R.fail("1","1");
    }
}
