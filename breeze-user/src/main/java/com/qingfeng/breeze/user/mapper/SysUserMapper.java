package com.qingfeng.breeze.user.mapper;

import com.qingfeng.breeze.api.base.BaseMapper;
import com.qingfeng.breeze.user.dto.SysUserDTO;
import com.qingfeng.breeze.user.model.SysUser;

public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUserDTO selectByLoginName (String loginName);

}