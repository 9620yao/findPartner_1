package com.yc.ssm.service;

import java.util.List;

import com.yc.ssm.entity.Login;
import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Users;

public interface UsersService {

	boolean insertUsers(Login login);

	boolean modifyUserInfo(Users users);

	/**
	 * 获得详细信息
	 * 
	 * @param alid
	 * @return
	 */
	Users listUsersInfo(String uid);

	Users getUser(String aid);

	PaginationBean<Users> listUsers(String rows, String page);

	List<Users> findUsersByAid(String aid);
	/**
	 * 获取登录id
	 */
	Users getuserByulid(Users users);

}
