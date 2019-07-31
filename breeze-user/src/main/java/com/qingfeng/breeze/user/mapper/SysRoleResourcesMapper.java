package com.qingfeng.breeze.user.mapper;


import com.qingfeng.breeze.api.base.BaseMapper;
import com.qingfeng.breeze.user.model.SysRoleResources;

public interface SysRoleResourcesMapper extends BaseMapper<SysRoleResources> {

    void deleteByRoleId (Integer roleId);
}