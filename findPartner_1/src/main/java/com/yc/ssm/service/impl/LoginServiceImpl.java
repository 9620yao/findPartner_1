package com.yc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.ssm.entity.Login;
import com.yc.ssm.mapper.LoginMapper;
import com.yc.ssm.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;

	@Override
	public Login login(Login partner) {
		return loginMapper.fingPartner(partner);
	}

	@Override
	public boolean register(Login partner) {
		return loginMapper.insertPar(partner) > 0;
	}

	@Override
	public List<Login> findEmail(Login partner) {
		return loginMapper.fingEmail(partner);
	}

	@Override
	public boolean updatePwd(Login partner) {
		return loginMapper.modifyPwd(partner) > 0;
	}

	@Override
	public void updateNewPwd(Login partner) {
		loginMapper.newPwd(partner);
	}

}
