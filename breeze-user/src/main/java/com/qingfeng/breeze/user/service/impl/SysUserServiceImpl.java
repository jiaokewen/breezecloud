package com.qingfeng.breeze.user.service.impl;

import com.qingfeng.breeze.api.base.BaseServiceImpl;
import com.qingfeng.breeze.api.constants.ResponseConsts;
import com.qingfeng.breeze.api.util.R;
import com.qingfeng.breeze.user.dto.SysUserDTO;
import com.qingfeng.breeze.user.mapper.SysResourcesMapper;
import com.qingfeng.breeze.user.mapper.SysRoleMapper;
import com.qingfeng.breeze.user.mapper.SysUserMapper;
import com.qingfeng.breeze.user.model.SysResources;
import com.qingfeng.breeze.user.model.SysRole;
import com.qingfeng.breeze.user.model.SysUser;
import com.qingfeng.breeze.user.service.SysRoleService;
import com.qingfeng.breeze.user.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qingfeng
 * @description: TODO
 * @date 2019/5/20 15:48
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService {

    private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysUserMapper mapper;

    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private SysResourcesMapper resourcesMapper;

    @Override
    public R<SysUserDTO> selectByLoginName(String loginName) {
        try {
            SysUserDTO user = mapper.selectByLoginName(loginName);
            if (user == null) {
                return R.success(ResponseConsts.SUCCESS,"查询成功",null);
            }
            List<SysResources> resources = resourcesMapper.selectByUserId(user.getUserId());
            List<String> list = new ArrayList<>();
            for (int i = 0, j = resources.size(); i < j; i ++) {
                list.add(resources.get(i).getResourcesCode());
            }
            user.setResources(list);
            return R.success(ResponseConsts.SUCCESS,"查询成功",user);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return R.fail(ResponseConsts.ERROR,"查询失败");
        }
    }
}
