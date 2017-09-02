package com.yc.ssm.service.impl;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.ssm.service.FriendService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class FriendsServiceImplTest {

	@Autowired
	private FriendService friendService;

	@Test
	public void testListFriends() {
		System.out.println(friendService.pfriends("2", "1", "5"));
	}

	@Test
	public void testInsertFriend() {
		fail("Not yet implemented");
	}

	@Test
	public void testListFrienfReq() {
		System.out.println(friendService.listFrienfReq("2"));
	}

	@Test
	public void testListIntroFriend() {
		System.out.println(friendService.listIntroFriend("3"));
	}

	@Test
	public void testCountReq() {
		System.out.println(friendService.countReq("2"));
	}

	@Test
	public void testListMaybeKnow() {
		System.out.println(friendService.listMaybeKnow("3"));
	}

}
