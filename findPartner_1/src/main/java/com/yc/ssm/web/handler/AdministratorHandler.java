package com.yc.ssm.web.handler;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yc.ssm.entity.Administrator;
import com.yc.ssm.service.AdministratorService;
import com.yc.ssm.util.ServletUtil;

@Controller("administratorHandler")
@RequestMapping("admin")
public class AdministratorHandler {

	@Autowired
	private AdministratorService administratorService;

	@RequestMapping("in")
	public String forword( HttpServletRequest request) {
		LogManager.getLogger().debug("forword()====>"  );
		return "redirect:/back/adminLogin.jsp";

	}

	@RequestMapping("adminLogin")
	public String login(Administrator administrator, HttpServletRequest request) {
		administrator = administratorService.adminLogin(administrator);
		LogManager.getLogger().debug("administrator====>" + administrator);
		if (administrator == null) {
			request.setAttribute(ServletUtil.ERROR_MESSAGE, "用户名或密码错误！！！");
			return "/back/adminLogin.jsp";
		} else {
			request.getSession().setAttribute(ServletUtil.ADMIN, administrator);
			return "redirect:/back/manager.jsp";
		}
	}
}
