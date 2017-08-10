package com.yc.ssm.web.handler;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.ssm.service.ReplysService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class PartnerHandlerTest {

	@Autowired
	private ReplysService replysService;
	
	@Test
	public void test() {
		System.out.println(replysService.listreplys("c10003"));
	}

}
