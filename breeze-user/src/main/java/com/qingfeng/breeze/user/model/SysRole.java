package com.qingfeng.breeze.user.model;

import lombok.Data;

@Data
public class SysRole {
    private Integer roleId;

    private String roleName;

    private String roleCode;

    private String description;
}