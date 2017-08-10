package com.yc.ssm.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.ssm.entity.Administrator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class AdministratorServiceTest {

	@Autowired
	private AdministratorService administratorService;

	@Test
	public void testLogin() {
		Administrator administrator = new Administrator();
		administrator.setBaemail("19216819@qq.com");
		administrator.setBapwd("a");
		administrator = administratorService.adminLogin(administrator);
		System.out.println(administrator);
		assertNotNull(administrator);
	}

}
