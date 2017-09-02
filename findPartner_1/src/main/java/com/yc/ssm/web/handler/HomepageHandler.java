package com.yc.ssm.web.handler;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.ssm.entity.Homepage;
import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.service.HomepageService;
import com.yc.ssm.util.ServletUtil;

/**
 * 
 * @author 姚秋林
 *
 */
@Controller("homepageHandler")
@RequestMapping("homepage")
public class HomepageHandler {

	@Autowired
	private HomepageService homepageService;

	/**
	 * 取数据有问题
	 * 
	 * @param faid
	 * @param currPage
	 * @return
	 */
	@RequestMapping("list")
	@ResponseBody
	public PaginationBean<Homepage> list(String faid, Integer currPage, HttpSession session) {
		String uid = (String) session.getAttribute(ServletUtil.USERAID);
		LogManager.getLogger().debug("我是 List<Homepage> 我进来了,faid:" + faid + ",uid=" + uid);
		if (uid != null && uid == faid) {// 如果相等则是当前登录用户，显示用户和好友自己的主页
			return homepageService.selflist(faid, String.valueOf(currPage), "10");
		}
		return homepageService.pbHomepage(faid, String.valueOf(currPage), "10");
	}

}
