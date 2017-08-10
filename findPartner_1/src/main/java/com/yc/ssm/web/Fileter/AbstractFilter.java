package com.yc.ssm.web.Fileter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public abstract class AbstractFilter implements Filter{

	public AbstractFilter() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	@Override
	public abstract void doFilter(ServletRequest requset, ServletResponse response, FilterChain chain)
			throws IOException, ServletException;
	
}
