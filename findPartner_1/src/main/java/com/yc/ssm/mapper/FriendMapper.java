package com.yc.ssm.mapper;

import java.util.List;
import java.util.Map;

import com.yc.ssm.entity.Users;

public interface FriendMapper {

	List<Users> listFriendsInfo(String aid);

	int addFriend(Map<String,String> map);

	List<Users> findFriendReq(String aid);

	List<Users> findIntroFriend(String aid);
	//取到请求添加你为好友的人数
	int listCountReq(String aid);

	List<Map<String, Object>> findMaybeKnow(String aid);

}
