package com.yc.ssm.listener;


import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.yc.ssm.util.ServletUtil;

@WebListener
public class DataListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce)  { 

	}
	public void contextInitialized(ServletContextEvent sce)  {
		String deployName=sce.getServletContext().getContextPath();
		ServletUtil.DEPLOY_NAME=deployName+"/";
		sce.getServletContext().setAttribute("deployName", ServletUtil.DEPLOY_NAME);
		ServletUtil.UPLOAD_DIR=sce.getServletContext().getRealPath(ServletUtil.VIRTUAL_UPLOAD_DIR).replace(deployName.substring(1)+File.separator, "");//文件上传目录
	}

}
