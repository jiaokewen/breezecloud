package com.qingfeng.breeze.user.mapper;

import com.qingfeng.breeze.api.base.BaseMapper;
import com.qingfeng.breeze.user.model.SysRole;

import java.util.List;

public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRole> selectByUserId (Integer userId);

}