package com.yc.ssm.web.handler;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yc.ssm.entity.Aress;
import com.yc.ssm.entity.Login;
import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Users;
import com.yc.ssm.service.AressService;
import com.yc.ssm.service.LoginService;
import com.yc.ssm.service.UsersService;
import com.yc.ssm.util.ServletUtil;

import net.coobird.thumbnailator.Thumbnails;

@Controller("usersHandler")
@RequestMapping("user")
public class UsersHandler {

	@Autowired
	private UsersService usersService;

	@Autowired
	private LoginService partnerService;

	@Autowired
	private AressService aressService;

	// 显示个人信息，通过aid取到个人信息
	@RequestMapping(value = "getByid", method = RequestMethod.GET)
	@ResponseBody
	public Users list(String faid, HttpSession session) {
		LogManager.getLogger().debug("ServletUtil.FINALAID==>" + faid);
		return usersService.listUsersInfo(faid);
	}

	/**
	 * 修改个人信息
	 * 
	 * @param picData：图片
	 * @param users：修改得user对象
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String modify(@RequestParam("picData") MultipartFile picData, Users users, HttpSession session) {
		LogManager.getLogger().debug("picData==>" + picData, "，user==>" + users);
		File dest = null;
		if (picData != null && !picData.isEmpty()) {
			String picPath = null;
			try {
				dest = ServletUtil.getUploadFile(picData.getOriginalFilename());
				// 压缩图片并上传
				Thumbnails.of(picData.getInputStream()).scale(1f).outputQuality(0.25f).toFile(dest);
				picPath = ServletUtil.VIRTUAL_UPLOAD_DIR + "/" + picData.getOriginalFilename();
			} catch (Exception e) {
				try {
					picData.transferTo(dest);
				} catch (IllegalStateException | IOException e1) {
					e1.printStackTrace();
				}
			}
			users.setPicture(picPath);
			System.out.println("上传图片==》" + users);
		}
		usersService.modifyUserInfo(users);
		return "redirect:/page/lw-index.jsp?aid=" + users.getUid();
	}

	/**
	 * 
	 * @param hprovince：家乡的省
	 * @param hcity：家乡的市
	 * @param hdistrict：家乡的区
	 * @param aress：住址
	 * @param login：登录表的个人信息
	 * @param users：用户表的个人信息
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "change", method = RequestMethod.POST)
	@Transactional
	public String changeinfo(@PathParam("hprovince") String hprovince, @PathParam("hcity") String hcity,
			@PathParam("hdistrict") String hdistrict, Aress aress, Login login, Users users, HttpSession session) {
		LogManager.getLogger().debug("aress" + aress + "Login=" + login + ",user==>" + users + ",hprovince=" + hprovince
				+ ",hcity=" + hcity + ",hdistrict=" + hdistrict);
		String uid = (String) session.getAttribute(ServletUtil.USERAID);
		Aress haress = new Aress(hprovince, hcity, hdistrict);
		Map<String, Object> map = aressService.isAress(aress);
		Map<String, Object> maph = aressService.isAress(haress);
		Integer asid = null;
		Integer hasid = null;
		if (partnerService.changLogin(login)) {// 修改成功
			if ((boolean) map.get("idAress")) {// 不存在，则添加
				aressService.insertAs(aress);
				asid = aress.getAsid();
			} else {
				asid = (Integer) map.get("asid");
			}
			if ((boolean) maph.get("idAress")) {
				aressService.insertAs(haress);
				hasid = haress.getAsid();
			} else {
				hasid = (Integer) maph.get("asid");
			}
			LogManager.getLogger().debug("asid=" + asid + ",hasid=" + hasid);
			if (asid != null && hasid != null) {
				users.setAddress(String.valueOf(asid));
				users.setHometown(String.valueOf(hasid));
				users.setUid(uid);
				usersService.modifyUserInfo(users);// 修改个人信息
			}
		}
		return "redirect:/page/lw-info.jsp?aid=" + uid;
	}

	/**
	 * 修改密码
	 * 
	 * @param strmdpwd
	 * @param newPassword
	 * @param partner
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "mofifyPwd", method = RequestMethod.POST)
	public String modifyPwd(@RequestParam("strmdpwd") String strmdpwd, @RequestParam("newPassword") String newPassword,
			Login partner, HttpServletRequest request) {
		LogManager.getLogger()
				.debug("partner====>" + partner + ",newPassword==>" + newPassword + ",strmdpwd=" + strmdpwd);
		if (partnerService.login(partner) == null) {
			request.setAttribute(ServletUtil.MODIF_ERROR, "用户名或密码错误！！！");
			return strmdpwd.split("/findPartner")[1];
		} else {
			partner.setPassword(newPassword);
			String lid = (String) request.getSession().getAttribute(ServletUtil.LOGINING_ID);
			partner.setLid(lid);
			partnerService.updatePwd(partner);
			return "lw-log";
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

	/**
	 * 加载个人资料
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "uid", method = RequestMethod.POST)
	@ResponseBody
	public Users byUid(HttpSession session) {
		String uid = (String) session.getAttribute(ServletUtil.USERAID);
		LogManager.getLogger().debug("我进来byAid()   aid==>" + uid);
		return usersService.listUsersInfo(uid);
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
