package com.yc.ssm.service.impl;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.ssm.entity.Speaks;
import com.yc.ssm.service.SpeaksService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class SpeaksServiceImplTest {

	@Autowired
	private SpeaksService speaksService;

	/**
	 * 分页显示测试
	 */
	@Test
	public void testListSpeaks() {
		System.out.println(speaksService.listSpeaks("3", "1", "5"));
	}

	@Test
	public void CountSpeaks() {
		System.out.println(speaksService.countSpeaks("3"));
	}

	/**
	 * 添加说说测试
	 */
	@Test
	public void testAdd() {
		Speaks speaks = new Speaks();
		speaks.setContent("我是用户3，我发表了一篇说说");
		speaks.setSpeakman("3");
		boolean ss = speaksService.add(speaks);
		System.out.println("sid=" + speaks.getSid() + ",uuid=" + speaks.getS_uuid());
		assertNotEquals(ss, false);
	}

}
