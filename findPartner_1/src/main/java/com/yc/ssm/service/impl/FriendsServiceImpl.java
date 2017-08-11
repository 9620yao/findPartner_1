package com.yc.ssm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.ssm.entity.Users;
import com.yc.ssm.mapper.FriendMapper;
import com.yc.ssm.service.FriendService;

@Service("friendService")
public class FriendsServiceImpl implements FriendService {
	@Autowired
	private FriendMapper friendMapper;

	@Override
	public List<Users> listFriends(String uid) {
		return friendMapper.listFriendsInfo(uid);
	}

	@Override
	public boolean insertFriend(String uid, String fid) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("uid", uid);
		map.put("fid", fid);
		return friendMapper.addFriend(map) > 0;
	}

	@Override
	public List<Users> listFrienfReq(String uid) {
		return friendMapper.findFriendReq(uid);
	}

	@Override
	public List<Users> listIntroFriend(String uid) {
		List<Users> users = friendMapper.findIntroFriend(uid);
		List<Users> newUsers = new ArrayList<Users>();
		List<Integer> nums = new ArrayList<Integer>();
		if (users.size() > 3) {// 若数据大于3条则随机显示3条
			while (nums.size() < 3) { // 生成3个
				Random r = new Random();
				int j = r.nextInt(users.size());
				if (!nums.contains(j)) { // 判断不重复
					nums.add(j);
					newUsers.add(users.get(j));
				}
			}
		} else {// 若数据小于3条则不随机，直接显示
			newUsers = users;
		}
		return newUsers;
	}

	@Override
	public int countReq(String uid) {
		return friendMapper.listCountReq(uid);
	}

	@Override
	public List<Map<String, Object>> listMaybeKnow(String uid) {
		return friendMapper.findMaybeKnow(uid);
	}

}
