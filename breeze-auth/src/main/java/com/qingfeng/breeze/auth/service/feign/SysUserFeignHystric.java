package com.qingfeng.breeze.auth.service.feign;

import com.qingfeng.breeze.api.constants.ResponseConsts;
import com.qingfeng.breeze.api.util.R;
import com.qingfeng.breeze.auth.model.SysUser;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author qingfeng
 * @description: TODO
 * @date 2019/5/20 18:09
 */
@Component
public class SysUserFeignHystric implements FallbackFactory<SysUserFeign> {

    private static final Logger logger = LoggerFactory.getLogger(SysUserFeignHystric.class);

    @Override
    public SysUserFeign create(Throwable throwable) {
        throwable.printStackTrace();
        logger.error(throwable.getMessage());
        return new SysUserFeign(){
            @Override
            public R<SysUser> selectByLoginName(String loginName) {
                return R.fail(ResponseConsts.ERROR,"调取Feign接口失败");
            }
        };
    }
}
