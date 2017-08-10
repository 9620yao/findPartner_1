package com.yc.ssm.service;

import java.util.List;

import com.yc.ssm.entity.Login;
import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Users;

public interface UsersService {

	boolean insertUsers(Login login);

	boolean modifyUserInfo(Users users);

	Users listUsersInfo(String alid);

	Users listUsersInfoByAid(String aid);
	
	PaginationBean<Users> listUsers(String rows, String page);

	List<Users> findUsersByAid(String aid);

}
