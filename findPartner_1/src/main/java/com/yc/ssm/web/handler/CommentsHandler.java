package com.yc.ssm.web.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.ssm.entity.Comments;
import com.yc.ssm.service.CommentsService;
import com.yc.ssm.util.ServletUtil;

@Controller("commentsHandler")
@RequestMapping("comments")
public class CommentsHandler {

	@Autowired
	private CommentsService commentsService;

	/**
	 * 
	 * @param sid
	 *            说说或者留言编号
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public List<Comments> listComments(Comments comments, HttpServletRequest request) {
		LogManager.getLogger().debug("我进来了 listComments==== comments:" + comments);
		return commentsService.listComments(comments);// 所有的评论
	}

	/**
	 * 添加评论
	 * 
	 * @param comments
	 * @param sesssion
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public boolean add(Comments comments, HttpSession sesssion) {
		LogManager.getLogger().debug("我进来了 add()==== comments:" + comments);
		// 评论人为登录用户
		String comuserid = (String) sesssion.getAttribute(ServletUtil.USERAID);
		comments.setComuserid(comuserid);
		return commentsService.addComments(comments);// 根据传过来的添加界面，然后返回什么界面
	}

}
