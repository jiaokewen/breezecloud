package com.qingfeng.breeze.log.model;

import lombok.Data;

import java.util.Date;

/**
 * @author qingfeng
 * @description: TODO
 * @date 2019/4/24 14:11
 */
@Data
public class LoginLog {

    private String id;

    private String userName;

    private Date loginDate;

    private String ip;

}
