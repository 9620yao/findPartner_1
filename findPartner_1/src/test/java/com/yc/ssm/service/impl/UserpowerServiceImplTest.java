package com.yc.ssm.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.ssm.service.UserpowerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UserpowerServiceImplTest {

	@Autowired
	private UserpowerService userpowerService;

	@Test
	public void testUserpower() {
		System.out.println(userpowerService.userpower("a10099"));
	}
	
	@Test
	public void pblist() {
		System.out.println(userpowerService.pblist("2", "1"));
	}

}
