package com.yc.ssm.service;

import java.util.List;
import java.util.Map;

import com.yc.ssm.entity.Users;

public interface FriendService {
	List<Users> listFriends(String uid);

	boolean insertFriend(String uid, String fid);
	//取到请求添加我为好友的好友列表
	List<Users> listFrienfReq(String uid);
	//系统推荐好友
	List<Users> listIntroFriend(String uid);

	int countReq(String uid);
	
	//可能认识的人
	List<Map<String, Object>> listMaybeKnow(String uid);
	

}
