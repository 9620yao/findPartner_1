package com.yc.ssm.service;

import java.util.List;

import com.yc.ssm.entity.Login;

public interface LoginService {
	
	Login login(Login login);

	boolean register(Login login);

	List<Login> findEmail(Login login);

	boolean updatePwd(Login login);

	void updateNewPwd(Login login);

}
