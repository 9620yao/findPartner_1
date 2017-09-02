package com.yc.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.ssm.entity.Friends;
import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Speaks;
import com.yc.ssm.entity.Users;
import com.yc.ssm.mapper.FriendMapper;
import com.yc.ssm.service.FriendService;

@Service("friendService")
public class FriendsServiceImpl implements FriendService {
	@Autowired
	private FriendMapper friendMapper;

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

	/**
	 * 排优显示，后续添加
	 */
	@Override
	public List<Users> listIntroFriend(String uid) {
		return friendMapper.findIntroFriend(uid);
	}

	@Override
	public int countReq(String uid) {
		return friendMapper.listCountReq(uid);
	}

	@Override
	public List<Map<String, Object>> listMaybeKnow(String uid) {
		return friendMapper.findMaybeKnow(uid);
	}

	@Override
	public PaginationBean<Friends> pfriends(String uid, String page, String rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		PaginationBean<Speaks> pBean = new PaginationBean<Speaks>();
		if (page != null) {
			pBean.setCurrPage(Integer.parseInt(page));
		}
		if (rows != null) {
			pBean.setPageSize(Integer.parseInt(rows));
		}
		map.put("uid", uid);
		map.put("pBean", pBean);
		return friendMapper.pfriends(map);
	}

}
