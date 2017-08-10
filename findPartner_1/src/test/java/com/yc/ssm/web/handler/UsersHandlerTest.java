package com.yc.ssm.web.handler;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.ssm.entity.Login;
import com.yc.ssm.entity.Users;
import com.yc.ssm.service.UsersService;
import com.yc.ssm.service.WordsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UsersHandlerTest {

	@Autowired
	private UsersService usersService;

	@SuppressWarnings("unused")
	@Autowired
	private WordsService wordsService;

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	/*
	 * @Test public void adminInfo(){ Users admin=new Users();
	 * admin=usersService.listUsersInfos("a10027"); System.out.println(admin);
	 * assertNotNull(admin); }
	 */

	@Test
	public void testUpdateUserInfo() {
		Login partner = new Login();
		Users users = new Users("10000", "1", "suli", "18", "", "", "", "", "", "", "", "", "", "", "", partner);
		boolean result = usersService.modifyUserInfo(users);
		assertEquals(true, result);
	}

	/*@Test
	public void testWords() {

		List<Words> ws = wordsService.findWords(new Words());
		System.out.println(ws);

	}
*/
}
