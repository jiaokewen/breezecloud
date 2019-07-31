package com.qingfeng.breeze.user.vo;

import com.qingfeng.breeze.user.model.SysResources;
import lombok.Data;

import java.util.List;

/**
 * @author qingfeng
 * @description: TODO
 * @date 2019/7/31 10:34
 */
@Data
public class ResourcesTree extends SysResources {

    private List<ResourcesTree> children;

    public ResourcesTree (SysResources resources) {
        this.setIcon(resources.getIcon());
        this.setParentId(resources.getParentId());
        this.setResourcesCode(resources.getResourcesCode());
        this.setResourcesId(resources.getResourcesId());
        this.setResourcesName(resources.getResourcesName());
        this.setResourcesUrl(resources.getResourcesUrl());
        this.setType(resources.getType());
    }
}
