package com.yc.ssm.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.ssm.service.HomepageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class HomepageServiceImplTest {

	@Autowired
	private HomepageService homepageService;

	@Test
	public void testPbHomepage() {
		System.out.println(homepageService.pbHomepage("3", "2", "3"));
	}

	@Test
	public void testselflist() {
		System.out.println(homepageService.selflist("3", "1", "3"));
	}

}
