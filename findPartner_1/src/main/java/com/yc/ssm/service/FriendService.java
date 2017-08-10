package com.yc.ssm.service;

import java.util.List;
import java.util.Map;

import com.yc.ssm.entity.Users;

public interface FriendService {
	List<Users> listFriends(String aid);

	boolean insertFriend(String aid, String fid);
	//取到请求添加我为好友的好友列表
	List<Users> listFrienfReq(String aid);
	//系统推荐好友
	List<Users> listIntroFriend(String aid);

	int countReq(String aid);
	
	//可能认识的人
	List<Map<String, Object>> listMaybeKnow(String aid);
	

}
