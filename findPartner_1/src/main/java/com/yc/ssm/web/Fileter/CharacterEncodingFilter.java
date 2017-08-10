package com.yc.ssm.web.Fileter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/*")
public class CharacterEncodingFilter extends AbstractFilter{
	private String charset = "utf-8";

	@Override
	public void doFilter(ServletRequest requset, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		requset.setCharacterEncoding(charset);

		response.setCharacterEncoding(charset);
		response.setContentType("text/html;charset="+charset);		
		chain.doFilter(requset, response);//继续请求处理
	}

}
