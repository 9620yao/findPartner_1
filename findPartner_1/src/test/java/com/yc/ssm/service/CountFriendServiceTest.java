package com.yc.ssm.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class CountFriendServiceTest {

	@Test
	public void testListAllAlbums() {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("a");
		list.add("b");
		for (int i = 0; i < list.size(); i++) {
			list.get(i);
		}

		System.out.println(list);
	}

}
