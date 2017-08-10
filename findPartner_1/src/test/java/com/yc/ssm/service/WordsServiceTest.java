package com.yc.ssm.service;



import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Words;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class WordsServiceTest {
	
	@Autowired
	private WordsService wordsService;

	/*
	 * @Test public void testFindWords() { Words words=new Words(); List<Words>
	 * ws=wordsService.findWords(words); System.out.println(ws);
	 * assertNotNull(ws); }
	 */
	@Test
	public void testAdd() {
		Words words=new Words();
		words.setWaid("a30");
		words.setWcontent("我来留言了。。。。");
		words.setWfrendid("a28");
		System.out.println(words);
		assertNotNull(words);
	}
	
	@Test
	public void testListAllWords(){
		PaginationBean<Words> ss=wordsService.listAllWords("1", "5");
		System.out.println(ss);
		assertNotNull(ss);
	}
	
	@Test
	public void testCountSpeaks() {
		System.out.println(wordsService.countWords("a28"));
	}
}
