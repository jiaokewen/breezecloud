package com.qingfeng.breeze.user.model;

import lombok.Data;

import java.util.List;

@Data
public class SysResources {
    private Integer resourcesId;

    private String resourcesName;

    private String type;

    private Integer parentId;

    private String resourcesCode;

    private String resourcesUrl;

    private String icon;
}