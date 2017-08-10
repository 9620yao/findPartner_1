package com.yc.ssm.web.handler;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.ssm.entity.Homepage;
import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.service.HomepageService;

@Controller("homepageHandler")
@RequestMapping("homepage")
public class HomepageHandler {

	@Autowired
	private HomepageService homepageService;

	@RequestMapping("list")
	@ResponseBody
	public PaginationBean<Homepage> list(String faid, Integer currPage) {
		LogManager.getLogger().debug("我是 List<Homepage> 我进来了,faid:" + faid);
		return homepageService.pbHomepage(faid, String.valueOf(currPage), "10");
	}

	@RequestMapping("selflist")
	@ResponseBody
	public PaginationBean<Homepage> selflist(String faid, Integer currPage) {
		LogManager.getLogger().debug("我是 List<Homepage> 我进来了,faid:" + faid + ",currPage:" + currPage);
		return homepageService.selflist(faid, String.valueOf(currPage), "10");
	}

}
