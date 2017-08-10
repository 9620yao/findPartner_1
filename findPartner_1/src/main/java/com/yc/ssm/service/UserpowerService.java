package com.yc.ssm.service;

import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Userpower;

public interface UserpowerService {

	boolean userpower(String faid);

	boolean addpower(String faid);

	PaginationBean<Userpower> pblist(String rows, String page);

	boolean Updatepower(String faid);

}
