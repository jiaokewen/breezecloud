package com.qingfeng.breeze.user.controller;

import com.qingfeng.breeze.api.base.BaseController;
import com.qingfeng.breeze.api.util.R;
import com.qingfeng.breeze.user.dto.SysUserDTO;
import com.qingfeng.breeze.user.model.SysUser;
import com.qingfeng.breeze.user.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author qingfeng
 * @description: TODO
 * @date 2019/5/20 15:54
 */
@RestController
@RequestMapping(value = "/sysUser/")
public class SysUserController extends BaseController<SysUser>{

    @Autowired
    private SysUserService service;

    @GetMapping(value = "loginName/{loginName}")
    public R<SysUserDTO> selectByLoginName (@PathVariable("loginName") String loginName) {
        return service.selectByLoginName(loginName);
    }

    @PreAuthorize("hasAuthority('SYS_USER_TEST')")
    @GetMapping(value = "test/{loginName}")
    public R<SysUserDTO> test (@PathVariable("loginName") String loginName) {
        return service.selectByLoginName(loginName);
    }

    @PreAuthorize("hasAuthority('SYS_USER_TEST1')")
    @GetMapping(value = "test1/{loginName}")
    public R<SysUserDTO> test1 (@PathVariable("loginName") String loginName) {
        return service.selectByLoginName(loginName);
    }
}
