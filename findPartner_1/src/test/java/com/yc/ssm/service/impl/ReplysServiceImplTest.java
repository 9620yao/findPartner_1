package com.yc.ssm.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.ssm.entity.Replys;
import com.yc.ssm.service.ReplysService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ReplysServiceImplTest {

	@Autowired
	private ReplysService replysService;

	@Test
	public void testListreplys() {
		Replys replys = new Replys();
		replys.setRcid("13");
		System.out.println(replysService.listreplys(replys));
	}

}
