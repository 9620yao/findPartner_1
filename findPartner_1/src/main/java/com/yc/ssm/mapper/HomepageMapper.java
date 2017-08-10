package com.yc.ssm.mapper;

import java.util.Map;

import com.yc.ssm.entity.Homepage;
import com.yc.ssm.entity.PaginationBean;

public interface HomepageMapper {

	int addhomepage(Homepage homepage);

	PaginationBean<Homepage> pblist(Map<String, Object> map);

	PaginationBean<Homepage> selflist(Map<String, Object> map);

}
