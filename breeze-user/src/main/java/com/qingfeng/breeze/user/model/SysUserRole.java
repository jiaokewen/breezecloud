package com.qingfeng.breeze.user.model;

import lombok.Data;

@Data
public class SysUserRole {
    private Integer id;

    private Integer userId;

    private Integer roleId;

    public Integer getId() {
        return id;
    }
}