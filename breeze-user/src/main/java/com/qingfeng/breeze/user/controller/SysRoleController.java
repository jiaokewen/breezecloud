package com.qingfeng.breeze.user.controller;

import com.qingfeng.breeze.api.base.BaseController;
import com.qingfeng.breeze.api.util.R;
import com.qingfeng.breeze.user.model.SysRole;
import com.qingfeng.breeze.user.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author qingfeng
 * @description: TODO
 * @date 2019/5/24 10:58
 */
@RestController
@RequestMapping(value = "/sysRole/")
public class SysRoleController extends BaseController<SysRole> {

    @Autowired
    private SysRoleService service;

    @GetMapping(value = "userId/{userId}")
    public R<Map> selectByUserId (@PathVariable("userId") Integer userId) {
        return service.selectByUserId(userId);
    }

    @PostMapping(value = "saveUserRole")
    public R<Map> saveUserRole (@RequestParam(value = "userId") Integer userId, @RequestParam
            (value = "roleIds") String roleIds) {
        return service.saveUserRole(userId,roleIds);
    }
}
