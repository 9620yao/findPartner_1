package com.yc.ssm.web.handler;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.service.UserpowerService;
import com.yc.ssm.entity.Userpower;

@Controller("userpowerHandler")
@RequestMapping("power")
public class UserpowerHandler {

	@Autowired
	private UserpowerService userpowerService;

	@RequestMapping(value = "sure", method = RequestMethod.POST)
	@ResponseBody
	public boolean Userpower(String faid) {
		LogManager.getLogger().debug("我进来了 Userpower().. faid:" + faid);
		return userpowerService.userpower(faid);
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public boolean addpower(String faid) {
		LogManager.getLogger().debug("我进来了addpower.. faid:" + faid);
		return userpowerService.addpower(faid);
	}

	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public PaginationBean<Userpower> Listpower(String rows, String page) {
		LogManager.getLogger().debug("我进来了 Listpower().. ");
		return userpowerService.pblist(rows, page);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public boolean Updatepower(String faid) {
		LogManager.getLogger().debug("我进来了Updatepower().. ");
		return userpowerService.Updatepower(faid);
	}
}
