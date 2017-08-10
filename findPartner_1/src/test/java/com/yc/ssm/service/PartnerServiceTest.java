package com.yc.ssm.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.ssm.entity.Login;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class PartnerServiceTest {
	@Autowired
	private LoginService partnerService;

	@Test
	public void testLogin() {
		Login partner=new Login();
		partner.setEmail("1820267872@qq.com");
		partner.setPassword("woshisuli123");
		partner=partnerService.login(partner);
		System.out.println(partner);
		assertNotNull(partner);
	}
	
	@Test
	public void add() {
		Login partner=new Login();
		partner.setEmail("290966751@qq.com");
		partner.setPassword("aaa");
		partner=partnerService.login(partner);
		System.out.println(partner);
		assertNotNull(partner);
	}
	
	@Test
	public void modifyPwd(){
		Login partner=new Login();
		partner.setLid("28");
		partner.setPassword("aa");
		boolean result=partnerService.updatePwd(partner);
		assertEquals(true, result);
		
	}

}
