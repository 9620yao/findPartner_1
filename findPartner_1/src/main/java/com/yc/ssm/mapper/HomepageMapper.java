package com.yc.ssm.mapper;

import java.util.List;
import java.util.Map;

import com.yc.ssm.entity.Homepage;
import com.yc.ssm.entity.PaginationBean;

public interface HomepageMapper {

	PaginationBean<Homepage> pblist(Map<String, Object> map);

	PaginationBean<Homepage> selflist(Map<String, Object> map);
	
	List<Homepage> listhp(String uid);

}
