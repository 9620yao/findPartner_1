package com.yc.ssm.service.impl;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.ssm.entity.Speaks;
import com.yc.ssm.service.HomepageService;
import com.yc.ssm.service.SpeaksService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class SpeaksServiceImplTest {

	@Autowired
	private SpeaksService speaksService;

	@Autowired
	private HomepageService homepageService;

	/**
	 * 分页显示测试
	 */
	@Test
	public void testListSpeaks() {
		System.out.println(speaksService.listSpeaks("3", "2", "1"));
	}

	/**
	 * 插入数据并取得插入编号测试
	 */
	@Test
	public void insetSpeaks() {
		Speaks speaks = new Speaks();
		speaks.setSpeakman("3");
		speaks.setContent("我是来测试的23333...");
		speaksService.add(speaks);
		System.out.println("添加的speaks:" + speaks);
		speaks = speaksService.findSpeaks(speaks.getSid(), speaks.getSpeakman());
		System.out.println("查找后speaks:" + speaks);
		homepageService.addhompage(speaks.getSid(), speaks.getSpeakman(), speaks.getSenddate());
	}

	@Test
	public void CountSpeaks() {
		System.out.println(speaksService.countSpeaks("3"));
	}

	/**
	 * 测试加载所有的信息，一次加载
	 */
	@Test
	public void listSpeaks() {
		List<Speaks> lss = speaksService.lists("3");
		System.out.println(lss);
		assertNotNull(lss);
	}

}
