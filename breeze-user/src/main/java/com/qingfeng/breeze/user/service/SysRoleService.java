package com.qingfeng.breeze.user.service;

import com.qingfeng.breeze.api.base.BaseService;
import com.qingfeng.breeze.api.util.R;
import com.qingfeng.breeze.user.model.SysRole;

import java.util.List;

/**
 * @author qingfeng
 * @description: TODO
 * @date 2019/5/24 10:49
 */
public interface SysRoleService extends BaseService<SysRole> {

    /**
     * 根据用户id查询角色
     * @param userId
     * @return
     */
    R<SysRole> selectByUserId (Integer userId);

}
