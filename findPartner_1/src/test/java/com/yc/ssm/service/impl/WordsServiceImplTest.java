package com.yc.ssm.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.ssm.service.WordsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class WordsServiceImplTest {

	@Autowired
	private WordsService WordsService;

	@Test
	public void testListWords() {
		System.out.println(WordsService.listWords("a10056", "1", "10"));
	}

}
