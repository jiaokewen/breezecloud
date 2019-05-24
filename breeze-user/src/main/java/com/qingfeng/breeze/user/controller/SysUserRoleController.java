package com.qingfeng.breeze.user.controller;

import com.qingfeng.breeze.api.base.BaseController;
import com.qingfeng.breeze.user.model.SysUserRole;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qingfeng
 * @description: TODO
 * @date 2019/5/24 10:51
 */
@RestController
@RequestMapping(value = "/sysUserRole/")
public class SysUserRoleController extends BaseController<SysUserRole> {
}
