package com.yc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.ssm.entity.Login;
import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Users;
import com.yc.ssm.mapper.UsersMapper;
import com.yc.ssm.service.UsersService;

@Service("usersService")
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersMapper UsersMapper;

	@Override
	public boolean insertUsers(Login login) {
		return UsersMapper.insertUsers(login) > 0;
	}

	@Override
	public boolean modifyUserInfo(Users users) {
		return UsersMapper.updateUserInfo(users) > 0;
	}

	@Override
	public Users listUsersInfo(String alid) {
		return UsersMapper.findUsersInfo(alid);
	}

	@Override
	public Users listUsersInfoByAid(String aid) {
		return UsersMapper.findUsersInfoByAid(aid);
	}

	@Override
	public PaginationBean<Users> listUsers(String rows, String page) {
		PaginationBean<Users> pb = new PaginationBean<Users>();
		if (page != null) {
			pb.setCurrPage(Integer.parseInt(page));
		}
		if (rows != null) {
			pb.setPageSize(Integer.parseInt(rows));
		}
		pb = UsersMapper.partUsers(pb);
		return pb;
	}

	@Override
	public List<Users> findUsersByAid(String aid) {
		return UsersMapper.listUserByAid(aid);
	}

}
