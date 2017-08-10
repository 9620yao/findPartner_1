package com.yc.ssm.web.handler;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.ssm.entity.Speaks;
import com.yc.ssm.service.CommentsService;
import com.yc.ssm.service.HomepageService;
import com.yc.ssm.service.ReplysService;
import com.yc.ssm.service.SpeaksService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class SpeaksHandlerTest {

	@Autowired
	private SpeaksService speaksService;

	@SuppressWarnings("unused")
	@Autowired
	private CommentsService commentsService;

	@SuppressWarnings("unused")
	@Autowired
	private ReplysService replysService;
	
	@SuppressWarnings("unused")
	@Autowired
	private HomepageService homepageService;

	/*
	 * @Test public void testListSpeaks() { //取到当前用户下的所有说说 List<Speaks>
	 * listspeacks = speaksService.listSpeaks("a10056"); System.out.println(
	 * " listspeacks:===》"+listspeacks); //取到所有说说的说说编号 for (Speaks speaks :
	 * listspeacks) { String listcallid = speaks.getSid();
	 * System.out.println("listcallid==》"+listcallid); //取到该说说编号下的所有评论
	 * List<Comments> listComments = commentsService.listComments(listcallid);
	 * for (Comments comments : listComments) { //取到评论编号 String listrcid =
	 * comments.getCid(); System.out.println("listrcid==》"+listrcid);
	 * //取到评论编号下的所有回复 List<Replys>listReplys =
	 * replysService.listreplys(listrcid);
	 * System.out.println("listReplys==>"+listReplys); for (Replys replys :
	 * listReplys) { //取到回复编号下面的所有回复 String listRid = replys.getRid();
	 * List<Replys> listotherReplys = replysService.listreplys(listRid);
	 * System.out.println(listotherReplys); } } } }
	 */
	
	/*@Test
	public void testinsertSpeaks() {
		Speaks speaks = new Speaks();
		speaks.setContent("哈哈哈哈，终于成功了。");
		speaks.setSpeakman("a10056");
		if(speaksService.add(speaks)){
			String sid = speaksService.findSid();
			Speaks outspeaks = speaksService.findSpeaks(sid,"a10056");//取到刚刚添加的说说信息
			System.out.println(outspeaks);
			homepageService.addhompage(outspeaks.getSid(), outspeaks.getSpeakman(), outspeaks.getSenddate());
		}
	}*/
	
	@Test
	public void testFindByUnclearNames() {
		Speaks speaks=new Speaks();
		speaks.setSpeakman("28");
		List<Speaks> ss=speaksService.findSpeaksInfoByName(speaks);
		System.out.println(ss);
	}

}
