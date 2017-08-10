package com.yc.ssm.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.ssm.entity.Login;
import com.yc.ssm.service.LoginService;
import com.yc.ssm.service.UsersService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UsersServiceImplTest {

	@Autowired
	private UsersService sersService;

	@Autowired
	private LoginService loginService;

	/**
	 * 测试：注册时，直接创建个人信息表
	 */
	@Test
	public void inserttest() {
		Login login = new Login();
		login.setEmail("19216815@qq.com");
		login.setPassword("a");
		login.setGender("男");
		login.setPhone("15675456193");
		login.setUname("xiaowu");
		boolean r = loginService.register(login);
		System.out.println("login:"+login);
		boolean r2 = sersService.insertUsers(login);
		System.out.println("r="+r+",r2="+r2);
		assertNotEquals(false, r);
		assertNotEquals(false, r2);
	}

}
