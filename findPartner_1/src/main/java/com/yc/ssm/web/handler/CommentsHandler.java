package com.yc.ssm.web.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.ssm.entity.Comments;
import com.yc.ssm.service.CommentsService;
import com.yc.ssm.util.ServletUtil;

@Controller("commentsHandler")
@RequestMapping("comments")
public class CommentsHandler {

	@Autowired
	private CommentsService commentsService;

	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public List<Comments> listComments(String sid, HttpServletRequest request) {
		LogManager.getLogger().debug("我进来了 listComments==== callid:" + sid);
		return commentsService.listComments(sid);// 所有的评论
	}

	/**
	 * 添加评论
	 * 
	 * @param strcomment 页面的请求地址
	 * @param comments
	 * @param sesssion
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@RequestParam("strcomment") String strcomment, Comments comments, HttpSession sesssion) {
		LogManager.getLogger().debug("我进来了 add()==== comments:" + comments + ",strcomment==>" + strcomment);
		// 评论人为登录用户
		String comuserid = (String) sesssion.getAttribute(ServletUtil.USERAID);
		comments.setComuserid(comuserid);
		commentsService.addComments(comments);// 添加评论
		if (strcomment != null) {
			return "redirect:" + strcomment.split("/findPartner")[1];// 根据传过来的添加界面，然后返回什么界面
		}
		return "redirect:/page/lw-index.jsp";
	}

}
