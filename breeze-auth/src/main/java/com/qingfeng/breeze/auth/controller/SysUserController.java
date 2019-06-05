package com.qingfeng.breeze.auth.controller;

import com.netflix.discovery.converters.Auto;
import com.qingfeng.breeze.api.constants.ResponseConsts;
import com.qingfeng.breeze.api.util.R;
import com.qingfeng.breeze.auth.model.SysUser;
import com.qingfeng.breeze.auth.service.feign.SysUserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "loginName/{loginName}")
    public R<SysUser> selectByLoginName (@PathVariable("loginName") String loginName) {
        return sysUserFeign.selectByLoginName(loginName);
    }

    @GetMapping(value = "userInfo")
    public  R<Object> getUserInfo() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal == null) {
            return R.fail(ResponseConsts.SUCCESS,"获取用户信息失败");
        } else {
            return R.success(ResponseConsts.SUCCESS,"获取用户信息成功",principal);
        }
    }

}
