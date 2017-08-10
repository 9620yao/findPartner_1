package com.yc.ssm.web.handler;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.ssm.entity.Login;
import com.yc.ssm.entity.Users;
import com.yc.ssm.service.LoginService;
import com.yc.ssm.service.UsersService;
import com.yc.ssm.util.RandomNumUtil;
import com.yc.ssm.util.SendMailutil;
import com.yc.ssm.util.ServletUtil;

@Controller("loginHandler")
@RequestMapping("login")
public class LoginHandler {

	@Autowired
	private LoginService loginService;

	@Autowired
	private UsersService usersService;

	/**
	 * 
	 * @param login
	 * @param request
	 * @return
	 */
	@RequestMapping("login")
	public String login(Login login, HttpServletRequest request) {
		login = loginService.login(login);
		String aid = null;
		LogManager.getLogger().debug("login====>" + login);
		if (login == null) {
			request.setAttribute(ServletUtil.ERROR_MESSAGE, "用户名或密码错误！！！");
			return "/page/lw-log.jsp";
		} else {
			request.getSession().setAttribute(ServletUtil.LOGIN_USER, login);
			request.getSession().setAttribute(ServletUtil.LOGINING_ID, login.getLid());
			Users users = usersService.listUsersInfo(login.getLid());
			if (users != null) {
				// 取到用户id放到session会话里面
				aid = users.getUid();
				request.getSession().setAttribute(ServletUtil.USERAID, aid);
			}
			return "redirect:/page/lw-index.jsp?aid=" + aid;
		}
	}

	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping("sendMail")
	public void sendMail(ModelMap map, String email, PrintWriter out, HttpServletRequest request) {
		LogManager.getLogger().debug(email);
		Integer yzm = RandomNumUtil.getRandomNumber();// 生成六位不重复随机数
		request.getSession().setAttribute("yzm", yzm.toString());
		SendMailutil.activeAccountMail(mailSender, "findlogin注册验证信息", "您的验证码是：" + yzm + ",请认真确认后在是您的操作之后，在执行操作",
				"15675456193@163.com", email);
		out.print(yzm);
		out.flush();
		out.close();
	}

	/**
	 * 注册：先对注册邮箱进行判断，是否已经注册过了。 1、若该邮箱存在，注册失败。
	 * 2、若不存在，则注册成功。当前注册成功时，会初始化个人信息表，保证数据绑定和安全。 3、采取事物机制，添加失败，直接返回数据。
	 * 
	 * @param login
	 *            录入的注册信息
	 * @param request
	 * @return 视图
	 */
	@RequestMapping(value = "register", method = RequestMethod.POST)
	@Transactional
	public String add(Login login, HttpServletRequest request) {// 注册
		LogManager.getLogger().debug("我进了了login:" + login);
		List<Login> listmail = loginService.findEmail(login);// 判断是否被注册
		if (listmail.size() > 0) {// 邮箱已经存在
			request.getSession().setAttribute("emailError", "该邮箱已经注册！！！");
			return "/page/lw-re.jsp";// 返回注册页面
		} else {// 邮箱不存在
			if (loginService.register(login)) {// 注册登录表注册成功
				// 初始化个人信息表
				LogManager.getLogger().debug("注册成功后，当前用户login：" + login);
				if (usersService.insertUsers(login)) {// 初始化users表
					return "/page/lw-log.jsp";// 成功跳转到登录界面
				}
			}
			return "/page/lw-re.jsp";// 失败跳转到注册界面
		}
	}

	/**
	 * 邮箱
	 * 
	 * @param map
	 * @param login
	 * @param out
	 * @param request
	 */
	@RequestMapping("sendForgetMail")
	public void sendForgetMail(ModelMap map, Login login, PrintWriter out, HttpServletRequest request) {
		LogManager.getLogger().debug(login);
		Integer yzm = RandomNumUtil.getRandomNumber();// 生成六位不重复随机数
		request.getSession().setAttribute("yzm", yzm.toString());
		SendMailutil.activeAccountMail(mailSender, "findlogin忘记密码验证信息", "您的验证码是：" + yzm + ",请认真确认后在是您的操作之后，在执行操作",
				"15675456193@163.com", login.getEmail());
		out.print(yzm);
		out.flush();
		out.close();
	}

	/**
	 * 判断该邮箱是否注册
	 * 
	 * @param email：传入的邮箱
	 * 
	 * @return
	 */
	@RequestMapping("emailExist")
	@ResponseBody
	public boolean emailExist(String email) {
		Login login = new Login();
		login.setEmail(email);
		List<Login> listmail = loginService.findEmail(login);// 判断是否存在该用户
		if (listmail.size() > 0) {
			return true;
		}
		return false;
	}

	@RequestMapping(value = "forget", method = RequestMethod.POST)
	public String newPwd(String email) {
		return "redirect:/page/lw-newPwd.jsp?email=" + email;
	}

	@RequestMapping(value = "newPwd", method = RequestMethod.POST)
	public String newPwd(@RequestParam("newemail") String newemail, @RequestParam("newpwd") String newpwd) {
		LogManager.getLogger().debug("newemail==>" + newemail + "newpwd==>" + newpwd);
		Login login = new Login();
		login.setEmail(newemail);
		login.setPassword(newpwd);
		loginService.updateNewPwd(login);
		return "/page/lw-log.jsp";
	}

}
