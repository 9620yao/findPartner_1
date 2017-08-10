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

import com.yc.ssm.entity.Login;
import com.yc.ssm.util.ServletUtil;

@WebFilter("/page/*")
public class ACheckLoginUserFilter extends AbstractFilter {

	@Override
	public void doFilter(ServletRequest requset, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) requset;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession Session = req.getSession();
		String url = req.getRequestURI();
		LogManager.getLogger().debug("url=====" + url);
		Login partner = (Login) req.getSession().getAttribute(ServletUtil.LOGIN_USER);// loginUser
		if (!url.endsWith("lw-log.jsp") && !url.endsWith("lw-re.jsp")&& !url.endsWith("forgetPassword.jsp")&&!url.endsWith("lw-newPwd.jsp") && partner == null) {
			if (Session.getAttribute("errorMsg") == null) {
				Session.setAttribute("errorMsg", "请先登录！");
			}
			resp.sendRedirect(req.getServletContext().getContextPath() + "/page/lw-log.jsp");
		}
		chain.doFilter(requset, response);// 继续请求处理
	}

}
