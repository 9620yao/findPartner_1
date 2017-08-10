package com.yc.ssm.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Speaks;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class SpeaksServiceTest {
	@Autowired
	private SpeaksService speaksService;

	/*
	 * @Test public void testListSpeaksInfos() { List<Speaks>
	 * speaks=speaksService.listSpeaks("10000"); System.out.println(speaks);
	 * assertNotNull(speaks); <<<<<<< HEAD }
	 */

	/*
	 * @Test public void testListComments() { List<Comments> comments =
	 * speaksService.listComments("10020"); System.out.println(comments);
	 * assertNotNull(comments); }
	 */

	public void testAddSpeaks() {
		Speaks speaks = new Speaks();
		speaks.setContent("我是用户a28，我发表了一篇说说");
		speaks.setSpeakman("a28");
		speaks.setFiles("");
		speaks.getSenddate();
		// speaks.getSenddate();
		@SuppressWarnings("unused")
		boolean ss = speaksService.add(speaks);
		System.out.println(speaks);
		assertNotNull(speaks);
	}

	@Test
	public void testListSpeaks() {
		PaginationBean<Speaks> ss = speaksService.listAllSpeaks("1", "5");
		System.out.println(ss);
		assertNotNull(ss);
	}
	
	@Test
	public void testFindSpeaks() {
		@SuppressWarnings("resource")
		ApplicationContext ac=new ClassPathXmlApplicationContext(new String[]{"spring.xml"});
		ac.getBean("");
		System.out.println();
	}
	
	@Test
	public void testCountSpeaks() {
		System.out.println(speaksService.countSpeaks(""));
	}

}
