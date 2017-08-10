package com.yc.ssm.mapper;

import java.util.List;

import com.yc.ssm.entity.Login;

public interface LoginMapper {
	//登录操作
	Login fingPartner(Login partner);
	
	int insertPar(Login partner);
	
	List<Login> fingEmail(Login partner);

	int modifyPwd(Login partner);

	int newPwd(Login partner);
}
