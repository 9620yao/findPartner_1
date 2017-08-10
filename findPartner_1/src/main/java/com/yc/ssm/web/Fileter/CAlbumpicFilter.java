package com.yc.ssm.web.Fileter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;

import com.yc.ssm.util.ServletUtil;

@WebFilter("/page/albumpic.jsp")
public class CAlbumpicFilter extends AbstractFilter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		LogManager.getLogger().debug("初始化验证码filter...");
	}

	/**
	 * 验证码验证
	 * 
	 */
	@Override
	public void doFilter(ServletRequest Servletrequest, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest requset = (HttpServletRequest) Servletrequest;
		String abid = requset.getParameter("abid");//后面对abid改名 还有对带的参数进行加密
		LogManager.getLogger().debug("请求abid:"+abid);
		if(abid!=null){//把相册编号abid，放到session里面去
			requset.getSession().setAttribute(ServletUtil.ALBUMABID, abid);
		}
		chain.doFilter(requset, response);
	}

}
