package com.qingfeng.breeze.user.service.impl;

import com.qingfeng.breeze.api.base.BaseServiceImpl;
import com.qingfeng.breeze.api.constants.ResponseConsts;
import com.qingfeng.breeze.api.util.R;
import com.qingfeng.breeze.user.mapper.SysUserMapper;
import com.qingfeng.breeze.user.model.SysUser;
import com.qingfeng.breeze.user.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public R<SysUser> selectByLoginName(String loginName) {
        try {
            SysUser user = mapper.selectByLoginName(loginName);
            return R.success(ResponseConsts.SUCCESS,"查询成功",user);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return R.fail(ResponseConsts.ERROR,"查询失败");
        }
    }
}
