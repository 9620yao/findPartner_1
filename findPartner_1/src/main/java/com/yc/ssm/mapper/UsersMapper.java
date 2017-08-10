package com.yc.ssm.mapper;

import java.util.List;

import com.yc.ssm.entity.Login;
import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Users;

public interface UsersMapper {

	/**
	 * 传入登录用户，并创建个人信息user
	 * @param login 传入登录用户
	 * @return
	 */
	int insertUsers(Login login);

	Users findUsersInfo(String alid);

	int updateUserInfo(Users users);

	Users findUsersInfoByAid(String aid);

	PaginationBean<Users> partUsers(PaginationBean<Users> pb);

	List<Users> listUserByAid(String aid);
}
