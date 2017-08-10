package com.yc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Userpower;
import com.yc.ssm.entity.Users;
import com.yc.ssm.mapper.UserpowerMapper;
import com.yc.ssm.service.UserpowerService;

@Service("userpowerService")
public class UserpowerServiceImpl implements UserpowerService {

	@Autowired
	private UserpowerMapper userpowerMapper;

	@Override
	public boolean userpower(String faid) {
		List<Userpower> list = userpowerMapper.userpower(faid);
		if (list != null && list.size() > 0) {
			for (Userpower userpower : list) {
				String power = userpower.getUpower();
				if (power != null && power.intern() == "-1") {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean addpower(String faid) {
		return userpowerMapper.addpower(faid) > 0;
	}

	@Override
	public PaginationBean<Userpower> pblist(String rows, String page) {
		PaginationBean<Users> pb = new PaginationBean<Users>();
		if (page != null) {
			pb.setCurrPage(Integer.parseInt(page));
		}
		if (rows != null) {
			pb.setPageSize(Integer.parseInt(rows));
		}
		return userpowerMapper.pblist(pb);
	}

	@Override
	public boolean Updatepower(String faid) {
		return userpowerMapper.Updatepower(faid) > 0;
	}

}
