package com.qingfeng.breeze.user.service;

import com.qingfeng.breeze.api.base.BaseService;
import com.qingfeng.breeze.api.util.R;
import com.qingfeng.breeze.user.dto.SysUserDTO;
import com.qingfeng.breeze.user.model.SysUser;

/**
 * @author qingfeng
 * @description: TODO
 * @date 2019/5/20 15:48
 */
public interface SysUserService extends BaseService<SysUser> {

    R<SysUserDTO> selectByLoginName (String loginName);

}
