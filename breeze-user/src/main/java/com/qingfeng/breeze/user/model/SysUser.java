package com.qingfeng.breeze.user.model;

import lombok.Data;

import java.util.Date;

@Data
public class SysUser {
    private Integer userId;

    private String nickName;

    private String loginName;

    private String password;

    private String email;

    private String phoneNumber;

    private String wechatNumber;

    private Date lastLoginDate;

    private String sex;

    private Integer age;
}