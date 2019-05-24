package com.qingfeng.breeze.auth.service.feign;

import com.qingfeng.breeze.api.util.R;
import com.qingfeng.breeze.auth.model.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author qingfeng
 * @description: TODO
 * @date 2019/5/20 18:04
 */
@FeignClient(value = "breeze-user",fallbackFactory =SysUserFeignHystric.class)
public interface SysUserFeign {

    @RequestMapping(value = "/sysUser/loginName/{loginName}",method = RequestMethod.GET)
    R<SysUser> selectByLoginName(@PathVariable("loginName") String loginName);
}
