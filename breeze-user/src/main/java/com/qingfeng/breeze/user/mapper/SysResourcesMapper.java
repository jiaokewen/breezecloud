package com.qingfeng.breeze.user.mapper;

import com.qingfeng.breeze.api.base.BaseMapper;
import com.qingfeng.breeze.user.model.SysResources;
import com.qingfeng.breeze.user.model.SysRoleResources;

import java.util.List;

public interface SysResourcesMapper extends BaseMapper<SysResources> {

    List<SysResources> selectByUserId (Integer userId);

}