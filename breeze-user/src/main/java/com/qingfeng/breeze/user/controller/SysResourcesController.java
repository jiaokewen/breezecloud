package com.qingfeng.breeze.user.controller;

import com.qingfeng.breeze.api.base.BaseController;
import com.qingfeng.breeze.api.util.R;
import com.qingfeng.breeze.user.model.SysResources;
import com.qingfeng.breeze.user.service.SysResourcesService;
import com.qingfeng.breeze.user.vo.ResourcesTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author qingfeng
 * @description: TODO
 * @date 2019/5/24 10:57
 */
@RestController
@RequestMapping(value = "/sysResources/")
public class SysResourcesController extends BaseController<SysResources> {

    @Autowired
    private SysResourcesService service;

    @GetMapping(value = "getTree")
    public R<ResourcesTree> getTree () {
        return service.getTree();
    }

    @GetMapping(value = "roleId/{roleId}")
    public R<SysResources> selectByUserId (@PathVariable("roleId") Integer roleId) {
        return service.selectByRoleId(roleId);
    }

    @GetMapping
    public R<SysResources> list () {
        return service.list();
    }
}
