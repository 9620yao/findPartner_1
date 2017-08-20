package com.yc.ssm.service;

import com.yc.ssm.entity.Homepage;
import com.yc.ssm.entity.PaginationBean;

public interface HomepageService {

	PaginationBean<Homepage> pbHomepage(String hpuseid, String currPage, String pageSize);

	PaginationBean<Homepage> selflist(String hpuseid, String currPage, String pageSize);

}
