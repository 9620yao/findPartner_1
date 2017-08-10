package com.yc.ssm.service.impl;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.ssm.service.SpeaksService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class SpeaksServiceImplTest {

	@Autowired
	private SpeaksService speaksService;
	
	@Test
	public void testListSpeaks() {
		System.out.println(speaksService.listSpeaks("a10056", "1", "10"));
	}
	
	/*@Test
	public void testDelSpeaks() {
		Speaks speaks=new Speaks();
		speaks.setSid("s10039");
		speaksService.delSpeaks(speaks);
		System.out.println("删除成功");
	}*/

}
