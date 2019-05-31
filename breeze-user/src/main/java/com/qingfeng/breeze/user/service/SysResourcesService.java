package com.qingfeng.breeze.user.service;

import com.qingfeng.breeze.api.base.BaseService;
import com.qingfeng.breeze.api.util.R;
import com.qingfeng.breeze.user.model.SysResources;
import com.qingfeng.breeze.user.model.SysRoleResources;

import java.util.List;

/**
 * @author qingfeng
 * @description: TODO
 * @date 2019/5/24 10:49
 */
public interface SysResourcesService extends BaseService<SysResources> {

    /**
     * 根据用户id查询资源
     * @param userId
     * @return
     */
    R<SysResources> selectByUserId (Integer userId);

}
