package com.qingfeng.breeze.user.controller;

import com.qingfeng.breeze.api.base.BaseController;
import com.qingfeng.breeze.user.model.SysUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qingfeng
 * @description: TODO
 * @date 2019/5/20 15:54
 */
@RestController
@RequestMapping(value = "/sysUser/")
public class SysUserController extends BaseController<SysUser> {
}
