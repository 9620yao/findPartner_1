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

import com.yc.ssm.entity.Replys;
import com.yc.ssm.service.ReplysService;
import com.yc.ssm.util.ServletUtil;

@Controller("replysHandler")
@RequestMapping("replys")
public class ReplysHandler {
	@Autowired
	private ReplysService replysService;

	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public List<Replys> listReplys(String cid, HttpServletRequest request) {
		LogManager.getLogger().debug("我进来了 listReplys==== callid:" + cid);
		return replysService.listreplys(cid);// 所有的回复
	}

	/**
	 * 添加回复
	 * 
	 * @param replys
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addReplys(@RequestParam("strreplys") String strreplys, Replys replys, HttpSession session) {
		LogManager.getLogger().debug("我进来了 listReplys==== replys:" + replys + ",strreplys==>" + strreplys);
		// 回复人为用户编号
		String ruserid = (String) session.getAttribute(ServletUtil.USERAID);
		replys.setRuserid(ruserid);
		replysService.addReplys(replys);
		if (strreplys != null) {
			return "redirect:" + strreplys.split("/findPartner")[1];
		}
		return "redirect:/page/lw-index.jsp";// 所有的回复
	}

}
