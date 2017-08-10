package com.yc.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.ssm.entity.Administrator;
import com.yc.ssm.mapper.AdministratorMapper;
import com.yc.ssm.service.AdministratorService;

@Service("administratorService")
public class AdministratorServiceImpl implements AdministratorService {
	
	@Autowired
	private AdministratorMapper administratorMapper;
	
	@Override
	public Administrator adminLogin(Administrator administrator) {
		return administratorMapper.fingAdmin(administrator);
	}

}
