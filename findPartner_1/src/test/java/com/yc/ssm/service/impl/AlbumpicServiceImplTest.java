package com.yc.ssm.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.ssm.entity.Albumpic;
import com.yc.ssm.service.AlbumpicService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class AlbumpicServiceImplTest {

	@Autowired
	private AlbumpicService albumpicService;
	
	@Test
	public void testListApic() {
		List<Albumpic> list = albumpicService.listApic("ab10000");
		System.out.println(list);
		assertNotNull(list);
	}
	
	/*@Test
	public void testNewPic() {
		boolean result = albumpicService.newpic("asf", "asdfa");
		System.out.println(result);
		assertNotNull(result);
	}*/
	
}
