package com.yc.ssm.web.handler;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		// 取到登录用户编号，并存到user用户中
		users.setUid((String) session.getAttribute(ServletUtil.USERAID));
		File dest = null;
		if (picData != null && !picData.isEmpty()) {
			String picPath = null;
			try {
				dest = ServletUtil.getUploadFile(picData.getOriginalFilename());
				// 1、压缩图片并上传
				Thumbnails.of(picData.getInputStream()).scale(1f).outputQuality(0.25f).toFile(dest);
				// 获取上传地址
				picPath = ServletUtil.VIRTUAL_UPLOAD_DIR + "/" + picData.getOriginalFilename();
			} catch (Exception e) {
				// 2、压缩上传失败，采用springmvc自带的图片上传
				try {
					picData.transferTo(dest);
				} catch (IllegalStateException | IOException e1) {
					e1.printStackTrace();
				}
			}
			// 上传图片的地址存到user
			users.setPicture(picPath);
			LogManager.getLogger().debug("上传图片==》" + users);
		}
		// 修改图片
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
		// 获取登录用户的编号
		String uid = (String) session.getAttribute(ServletUtil.USERAID);
		// 获取到家乡地址，并存在Aress中
		Aress haress = new Aress(hprovince, hcity, hdistrict);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> maph = new HashMap<String, Object>();
		Integer asid = null;
		Integer hasid = null;
		// 1、首先修改log信息
		if (partnerService.changLogin(login)) {// 修改成功
			map = aressService.isAress(aress);
			maph = aressService.isAress(haress);
			// 2、修改user信息之前对地址进行确认，判断数据库是否存在该地址，若存在，返回地址编号。不存在，则添加，并获取插入的地址编号。
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
			// 3、修改user表个人信息
			if (asid != null && hasid != null) {
				users.setAddress(String.valueOf(asid));
				users.setHometown(String.valueOf(hasid));
				users.setUid(uid);
				usersService.modifyUserInfo(users);
			}
		}
		return "redirect:/page/lw-info.jsp?aid=" + uid;
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

}
