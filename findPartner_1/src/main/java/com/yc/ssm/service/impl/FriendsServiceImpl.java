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
	public List<Users> listFriends(String aid) {
		return friendMapper.listFriendsInfo(aid);
	}

	@Override
	public boolean insertFriend(String aid, String fid) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("aid", aid);
		map.put("fid", fid);
		return friendMapper.addFriend(map) > 0;
	}

	@Override
	public List<Users> listFrienfReq(String aid) {
		return friendMapper.findFriendReq(aid);
	}

	@Override
	public List<Users> listIntroFriend(String aid) {
		List<Users> users = friendMapper.findIntroFriend(aid);
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
	public int countReq(String aid) {
		return friendMapper.listCountReq(aid);
	}

	@Override
	public List<Map<String, Object>> listMaybeKnow(String aid) {
		return friendMapper.findMaybeKnow(aid);
	}

}
