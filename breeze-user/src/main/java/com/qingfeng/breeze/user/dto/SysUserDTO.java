package com.qingfeng.breeze.user.dto;

import com.qingfeng.breeze.user.model.SysResources;
import com.qingfeng.breeze.user.model.SysRole;
import com.qingfeng.breeze.user.model.SysUser;
import lombok.Data;

import java.util.List;

/**
 * @author qingfeng
 * @description: TODO
 * @date 2019/6/3 8:53
 */
@Data
public class SysUserDTO extends SysUser {

    private List<String> resources;

}
