package com.qingfeng.breeze.user.service.impl;

import com.qingfeng.breeze.api.base.BaseServiceImpl;
import com.qingfeng.breeze.api.constants.ResponseConsts;
import com.qingfeng.breeze.api.util.R;
import com.qingfeng.breeze.user.mapper.SysResourcesMapper;
import com.qingfeng.breeze.user.mapper.SysRoleMapper;
import com.qingfeng.breeze.user.model.SysResources;
import com.qingfeng.breeze.user.service.SysResourcesService;
import com.qingfeng.breeze.user.vo.ResourcesTree;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qingfeng
 * @description: TODO
 * @date 2019/5/24 10:50
 */
@Service
public class SysResourcesServiceImpl extends BaseServiceImpl<SysResources> implements SysResourcesService {

    private static final Logger logger = LoggerFactory.getLogger(SysResourcesServiceImpl.class);

    @Autowired
    private SysResourcesMapper mapper;

    @Override
    public R<SysResources> selectByUserId(Integer userId) {
        try {
            List<SysResources> list = mapper.selectByUserId(userId);
            return R.success(ResponseConsts.SUCCESS,"查询成功",list);
        }catch (Exception e) {
            logger.error("查询资源失败",e.getMessage());
            return R.fail(ResponseConsts.ERROR,"查询资源失败");
        }
    }

    @Override
    public R<ResourcesTree> getTree() {
        try {
            List<SysResources> list = mapper.list();
            List<ResourcesTree> result = new ArrayList<>();
            for (SysResources item : list) {
                if (item.getParentId() == null) {
                    result.add(this.buildChildren(new ResourcesTree(item),list));
                }
            }
            return R.success(ResponseConsts.SUCCESS,"查询成功",result);
        }catch (Exception e) {
            logger.error("查询资源树失败",e.getMessage());
            return R.fail(ResponseConsts.SUCCESS,"查询资源树失败");
        }

    }

    @Override
    public R<SysResources> selectByRoleId(Integer roleId) {
        try {
            List<SysResources> list = mapper.selectByRoleId(roleId);
            return R.success(ResponseConsts.SUCCESS,"查询成功",list);
        }catch (Exception e) {
            logger.error("查询资源失败",e.getMessage());
            return R.fail(ResponseConsts.ERROR,"查询资源失败");
        }
    }

    @Override
    public R<SysResources> list() {
        try {
            List<SysResources> list = mapper.list();
            return R.success(ResponseConsts.SUCCESS,"查询成功",list);
        }catch (Exception e) {
            logger.error("查询资源失败",e.getMessage());
            return R.fail(ResponseConsts.ERROR,"查询资源失败");
        }
    }

    /**
     * 构建父节点的子节点
     * @param p
     * @param list
     * @return
     */
    private ResourcesTree buildChildren (ResourcesTree p, List<SysResources> list) {
        List<ResourcesTree> child = new ArrayList<>();
        for (SysResources item : list) {
            if (p.getResourcesId().equals(item.getParentId())) {
                child.add(buildChildren(new ResourcesTree(item),list));
            }
        }
        p.setChildren(child);
        return p;
    }
}
