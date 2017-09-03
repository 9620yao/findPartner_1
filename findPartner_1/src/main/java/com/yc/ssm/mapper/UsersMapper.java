package com.yc.ssm.mapper;

import java.util.List;

import com.yc.ssm.entity.Login;
import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Users;

public interface UsersMapper {

	/**
	 * 传入登录用户，并创建个人信息user
	 * 
	 * @param login
	 *            传入登录用户
	 * @return
	 */
	int insertUsers(Login login);

	/**
	 * 获得详细信息
	 * 
	 * @param uid
	 * @return
	 */
	Users Userinfo(String uid);

	/**
	 * 修改个人信息
	 * 
	 * @param users
	 * @return
	 */
	int updateUserInfo(Users users);

	Users getUserinfo(String uid);

	/**
	 * 分页查询
	 * 
	 * @param pb
	 * @return
	 */
	PaginationBean<Users> partUsers(PaginationBean<Users> pb);

	List<Users> listUserByAid(String aid);

	Users getuser();

	/**
	 * y用于登录操作
	 * 
	 */
	Users getuserByulid(Users users);
}
