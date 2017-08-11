package com.yc.ssm.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.ssm.entity.Users;
import com.yc.ssm.service.FriendService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class FriendsServiceImplTest {

	@Autowired
	private FriendService friendService;
	
	@Test
	public void testListFriends() {
		List<Users> users=friendService.listFriends("3");
		System.out.println(users);
		assertNotNull(users);
	}

	@Test
	public void testInsertFriend() {
		fail("Not yet implemented");
	}

	@Test
	public void testListFrienfReq() {
		fail("Not yet implemented");
	}

	@Test
	public void testListIntroFriend() {
		fail("Not yet implemented");
	}

	@Test
	public void testCountReq() {
		fail("Not yet implemented");
	}

	@Test
	public void testListMaybeKnow() {
		fail("Not yet implemented");
	}

}
