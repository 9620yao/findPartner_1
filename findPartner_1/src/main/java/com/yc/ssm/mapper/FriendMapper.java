package com.yc.ssm.mapper;

import java.util.List;
import java.util.Map;

import com.yc.ssm.entity.Friends;
import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Users;

public interface FriendMapper {

	/**
	 * 分页显示用户下的好友信息
	 * @param aid
	 * @return
	 */
	PaginationBean<Friends> pfriends(Map<String,Object> map);

	int addFriend(Map<String, String> map);

	List<Users> findFriendReq(String aid);

	List<Users> findIntroFriend(String aid);

	// 取到请求添加你为好友的人数
	int listCountReq(String aid);

	/**
	 * 显示可能认识的人
	 * @param aid
	 * @return
	 */
	List<Map<String, Object>> findMaybeKnow(String aid);

}
