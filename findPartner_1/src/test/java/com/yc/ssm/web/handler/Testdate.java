package com.yc.ssm.web.handler;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Testdate {

	public static void main(String[] args) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间	
		String str = "http://localhost:8080/findPartner/page/lw-speaks.jsp?aid=a10056";
		System.out.println(str.split("/findPartner")[1]);
	
	}
}
