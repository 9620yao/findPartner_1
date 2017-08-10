package com.yc.ssm.util;

import java.io.File;

public class ServletUtil {
	public static final String LOGIN_USER = "loginUser";// 登录用户
	public static final String ERROR_MESSAGE = "errorMsg";
	public static String DEPLOY_NAME;
	public static final String USER_INFO = "userInfo";
	public static final String USERAID = "useraid";
	public static final String FINALAID = "finalaid";// 存放查看当前用户的用户编号
	public static final String ALBUMABID = "albumabid";// 相册编号
	
	public static final String MODIF_ERROR = "errorpwd";//添加图片错误
	public static String UPLOAD_DIR;
	public static String VIRTUAL_UPLOAD_DIR = "/upload03/";

	public static final String LOGINING_ID = "logining";// 登录用户的登录id
	public static final String ADMIN = "admin";

	public static File getUploadFile(String fileName) {
		File file = new File(UPLOAD_DIR, fileName);// 上传文件
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		return file;

	}

}
