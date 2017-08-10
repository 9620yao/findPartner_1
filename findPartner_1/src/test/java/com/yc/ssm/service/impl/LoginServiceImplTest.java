package com.yc.ssm.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.ssm.entity.Login;
import com.yc.ssm.service.LoginService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class LoginServiceImplTest {

	@Autowired
	private LoginService loginService;

	/**
	 * 测试能否直接添加成功
	 */
	@Test
	public void Inserttest() {
		Login login = new Login();
		login.setEmail("19216815@qq.com");
		login.setPassword("a");
		login.setGender("男");
		login.setPhone("15675456193");
		login.setUname("xiaowu");
		boolean r = loginService.register(login);
		System.out.println(r);
		assertNotEquals(false, r);
	}

}
