package com.yc.ssm.service;

import com.yc.ssm.entity.Homepage;
import com.yc.ssm.entity.PaginationBean;

public interface HomepageService {

	void addhompage(String hpid, String hpuseid, String hpdate);

	PaginationBean<Homepage> pbHomepage(String hpuseid, String currPage, String pageSize);

	PaginationBean<Homepage> selflist(String hpuseid, String currPage, String pageSize);

}
