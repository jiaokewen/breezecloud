package com.qingfeng.breeze.user;

import com.qingfeng.breeze.user.dto.SysUserDTO;
import com.qingfeng.breeze.user.mapper.SysUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class BreezeUserApplicationTests {

	@Autowired
	private SysUserMapper userMapper;

	@Test
	public void contextLoads() {
		SysUserDTO user = userMapper.selectByLoginName("admin");
		System.out.println(user);
	}

}
