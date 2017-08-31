package com.yc.ssm.service.impl;

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
	public void TestListApic(){
		Albumpic albumpic = new Albumpic();
		albumpic.setAbid("2");
		albumpicService.findAlbumpic(albumpic);
	}

}
