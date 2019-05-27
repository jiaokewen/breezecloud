package com.qingfeng.breeze.user.mapper;

import com.qingfeng.breeze.api.base.BaseMapper;
import com.qingfeng.breeze.user.model.SysUser;

public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser selectByLoginName (String loginName);

}