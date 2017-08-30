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

import com.yc.ssm.entity.Replys;
import com.yc.ssm.service.ReplysService;
import com.yc.ssm.util.ServletUtil;

/**
 * 回复
 * 
 * @author 姚秋林
 *
 */
@Controller("replysHandler")
@RequestMapping("replys")
public class ReplysHandler {
	@Autowired
	private ReplysService replysService;

	/**
	 * 查找回复
	 * 
	 * @param cid
	 *            评论或者回复编号
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public List<Replys> listReplys(Replys replys, HttpServletRequest request) {
		LogManager.getLogger().debug("我进来了 listReplys==== replys:" + replys);
		return replysService.listreplys(replys);// 所有的回复
	}

	/**
	 * 添加回复
	 * 
	 * @param replys
	 *            回复
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public boolean addReplys(Replys replys, HttpSession session) {
		LogManager.getLogger().debug("我进来了 listReplys==== replys:" + replys);
		// 回复人为用户编号
		String ruserid = (String) session.getAttribute(ServletUtil.USERAID);
		replys.setRuserid(ruserid);
		return replysService.addReplys(replys);// 所有的回复
	}

}
