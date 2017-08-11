package com.yc.ssm.web.handler;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Login;
import com.yc.ssm.entity.Users;
import com.yc.ssm.service.LoginService;
import com.yc.ssm.service.UsersService;
import com.yc.ssm.util.ServletUtil;

@Controller("usersHandler")
@RequestMapping("user")
public class UsersHandler {

	@Autowired
	private UsersService usersService;

	@Autowired
	private LoginService partnerService;

	// 显示个人信息，通过aid取到个人信息
	@RequestMapping(value = "getByid", method = RequestMethod.GET)
	@ResponseBody
	public Users list(String faid, HttpSession session) {
		LogManager.getLogger().debug("ServletUtil.FINALAID==>" + faid);
		return usersService.listUsersInfoByAid(faid);
	}

	/**
	 * 修改个人信息
	 * 
	 * @param picData 图片
	 * @param users	修改得user对象
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String modify(@RequestParam("picData") MultipartFile picData, Users users, HttpSession session) {
		LogManager.getLogger().debug("picData==>" + picData, "，user==>" + users);
		if (picData != null && !picData.isEmpty()) {
			String picPath = null;
			try {
				picData.transferTo(ServletUtil.getUploadFile(picData.getOriginalFilename()));
				picPath = ServletUtil.VIRTUAL_UPLOAD_DIR + "/" + picData.getOriginalFilename();
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			users.setPicture(picPath);
			System.out.println("上传图片==》" + users);
		}
		usersService.modifyUserInfo(users);
		return "redirect:/page/lw-index.jsp?aid=" + users.getUid();
	}

	// 修改密码
	@RequestMapping(value = "mofifyPwd", method = RequestMethod.POST)
	public String modifyPwd(@RequestParam("strmdpwd") String strmdpwd, @RequestParam("newPassword") String newPassword,
			Login partner, HttpServletRequest request) {
		LogManager.getLogger()
				.debug("partner====>" + partner + ",newPassword==>" + newPassword + ",strmdpwd=" + strmdpwd);
		if (partnerService.login(partner) == null) {
			request.setAttribute(ServletUtil.MODIF_ERROR, "用户名或密码错误！！！");
			return "redirect:" + strmdpwd.split("/findPartner")[1];
		} else {
			partner.setPassword(newPassword);
			String lid = (String) request.getSession().getAttribute(ServletUtil.LOGINING_ID);
			partner.setLid(lid);
			partnerService.updatePwd(partner);
			return "redirect:/page/lw-log.jsp";
		}

	}

	@RequestMapping(value = "mlist", method = RequestMethod.POST)
	@ResponseBody
	public PaginationBean<Users> listUsers(@RequestParam(value = "rows", required = false) String rows,
			@RequestParam(value = "page", required = false) String page) {
		LogManager.getLogger().debug("我进来了listUsers==》 ,rows=" + rows + "，page=" + page);
		return usersService.listUsers(rows, page);
	}

	// 后台超管根据aid查询用户信息
	@RequestMapping(value = "find", method = RequestMethod.POST)
	@ResponseBody
	public List<Users> findUsers(String aid) {
		LogManager.getLogger().debug("我进来了findUsers==》 ,aid=" + aid);
		return usersService.findUsersByAid(aid);
	}

	// 显示个人信息，通过aid取到个人信息
	@RequestMapping(value = "aid", method = RequestMethod.POST)
	@ResponseBody
	public Users byAid(String aid, HttpSession session) {
		LogManager.getLogger().debug("我进来byAid()   aid==>" + aid);
		return usersService.listUsersInfoByAid(aid);
	}

	// 显示个人信息，通过aid取到个人信息
	@RequestMapping(value = "sure", method = RequestMethod.POST)
	@ResponseBody
	public boolean blSurePwd(String email, String password, HttpSession session) {
		LogManager.getLogger().debug("我进来blSurePwd()   email==>" + email + ",password=" + password);
		Login partner = new Login();
		partner.setEmail(email);
		partner.setPassword(password);
		if (partnerService.login(partner) == null) {// 等于空说说密码或者账号错误
			return false;
		}
		return true;
	}

}
