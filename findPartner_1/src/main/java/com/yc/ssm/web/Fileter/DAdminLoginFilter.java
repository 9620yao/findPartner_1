package com.yc.ssm.web.Fileter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;

import com.yc.ssm.entity.Administrator;
import com.yc.ssm.util.ServletUtil;

@WebFilter("/back/*")
public class DAdminLoginFilter extends AbstractFilter {

	@Override
	public void doFilter(ServletRequest requset, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) requset;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession Session = req.getSession();
		String url = req.getRequestURI();
		LogManager.getLogger().debug("url=====" + url);
		Administrator admin = (Administrator) req.getSession().getAttribute(ServletUtil.ADMIN);// loginUser
		if (!url.endsWith("adminLogin.jsp") && admin == null) {
			if (Session.getAttribute("errorMsg") == null) {
				Session.setAttribute("errorMsg", "请先登录！");
			}
			resp.sendRedirect(req.getServletContext().getContextPath() + "/back/adminLogin.jsp");
		}
		chain.doFilter(requset, response);// 继续请求处理
	}

}
