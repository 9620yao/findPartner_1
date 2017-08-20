package com.yc.ssm.service.impl;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

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
