package com.qingfeng.breeze.user.service.impl;

import com.qingfeng.breeze.api.base.BaseServiceImpl;
import com.qingfeng.breeze.api.constants.ResponseConsts;
import com.qingfeng.breeze.api.util.R;
import com.qingfeng.breeze.user.mapper.SysRoleMapper;
import com.qingfeng.breeze.user.mapper.SysRoleResourcesMapper;
import com.qingfeng.breeze.user.mapper.SysUserRoleMapper;
import com.qingfeng.breeze.user.model.SysResources;
import com.qingfeng.breeze.user.model.SysRole;
import com.qingfeng.breeze.user.model.SysRoleResources;
import com.qingfeng.breeze.user.model.SysUserRole;
import com.qingfeng.breeze.user.service.SysRoleService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qingfeng
 * @description: TODO
 * @date 2019/5/24 10:50
 */
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole> implements SysRoleService {

    private static final Logger logger = LoggerFactory.getLogger(SysResourcesServiceImpl.class);

    @Autowired
    private SysRoleMapper mapper;

    @Autowired
    private SysUserRoleMapper userRoleMapper;

    @Autowired
    private SysRoleResourcesMapper sysRoleResourcesMapper;

    @Override
    public R<Map> selectByUserId(Integer userId) {
        try {
            List<SysRole> userRole = mapper.selectByUserId(userId);
            List<SysRole> allRole = mapper.list();
            Map<String, Object> map = new HashMap<>(2);
            map.put("userRole", userRole);
            map.put("allRole", allRole);
            return R.success(ResponseConsts.SUCCESS,"查询成功",map);
        }catch (Exception e) {
            logger.error("查询角色失败",e.getMessage());
            return R.success(ResponseConsts.ERROR,"查询角色失败");
        }
    }

    @Override
    public R saveUserRole(Integer userId, String roleIds) {
        try {
            userRoleMapper.deleteByUserId(userId);
            if (StringUtils.isNotEmpty(roleIds)) {
                String[] s = roleIds.split(",");
                for (String id : s) {
                    SysUserRole item = new SysUserRole();
                    item.setUserId(userId);
                    item.setRoleId(Integer.valueOf(id));
                    userRoleMapper.insert(item);
                }
            }
            return R.success(ResponseConsts.SUCCESS,"操作成功");
        }catch (Exception e) {
            return R.success(ResponseConsts.ERROR,"操作失败");
        }
    }

    @Override
    public R saveRoleResources(Integer roleId, String resourcesIds) {
        try {
            sysRoleResourcesMapper.deleteByRoleId(roleId);
            if (StringUtils.isNotEmpty(resourcesIds)) {
                String[] s = resourcesIds.split(",");
                for (String id : s) {
                    SysRoleResources item = new SysRoleResources();
                    item.setRoleId(roleId);
                    item.setResourcesId(Integer.valueOf(id));
                    sysRoleResourcesMapper.insert(item);
                }
            }
            return R.success(ResponseConsts.SUCCESS,"操作成功");
        }catch (Exception e) {
            return R.success(ResponseConsts.ERROR,"操作失败");
        }
    }
}
