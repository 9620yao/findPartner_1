package com.yc.ssm.mapper;

import java.util.List;

import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Userpower;
import com.yc.ssm.entity.Users;

public interface UserpowerMapper {

	List<Userpower> userpower(String faid);

	int addpower(String faid);

	PaginationBean<Userpower> pblist(PaginationBean<Users> pb);

	int Updatepower(String faid);

}
