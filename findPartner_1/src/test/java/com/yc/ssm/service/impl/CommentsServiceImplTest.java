package com.yc.ssm.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.ssm.entity.Comments;
import com.yc.ssm.mapper.CommentsMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class CommentsServiceImplTest {

	@Autowired
	private CommentsMapper commentsMapper;
	
	@Test
	public void test() {
		Comments comments = new Comments();
		comments.setC_uuid("33557de7-8d60-11e7-a461-40167e873601");
		comments.setCallid("26");
		System.out.println(commentsMapper.getcom(comments));
	}
}
