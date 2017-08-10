package com.yc.ssm.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.ssm.entity.Homepage;
import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Speaks;
import com.yc.ssm.mapper.HomepageMapper;
import com.yc.ssm.service.HomepageService;

@Service("homepageService")
public class HomepageServiceImpl implements HomepageService {

	@Autowired
	private HomepageMapper homepageMapper;

	@Override
	public void addhompage(String hpid, String hpuseid, String hpdate) {
		Homepage Homepage = new Homepage();
		Homepage.setHpid(hpid);
		Homepage.setHpuseid(hpuseid);
		Homepage.setHpdate(hpdate);
		homepageMapper.addhomepage(Homepage);
	}

	@Override
	public PaginationBean<Homepage> pbHomepage(String hpuseid, String currPage, String pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		PaginationBean<Speaks> pBean = new PaginationBean<Speaks>();
		if (currPage != null) {
			pBean.setCurrPage(Integer.parseInt(currPage));
		}
		if (pageSize != null) {
			pBean.setPageSize(Integer.parseInt(pageSize));
		}
		map.put("hpuseid", hpuseid);
		map.put("pBean", pBean);
		return homepageMapper.pblist(map);
	}

	@Override
	public PaginationBean<Homepage> selflist(String hpuseid, String currPage, String pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		PaginationBean<Speaks> pBean = new PaginationBean<Speaks>();
		if (currPage != null) {
			pBean.setCurrPage(Integer.parseInt(currPage));
		}
		if (pageSize != null) {
			pBean.setPageSize(Integer.parseInt(pageSize));
		}
		map.put("hpuseid", hpuseid);
		map.put("pBean", pBean);
		return homepageMapper.selflist(map);
	}

}
