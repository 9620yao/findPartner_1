package com.yc.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Speaks;
import com.yc.ssm.mapper.SpeaksMapper;
import com.yc.ssm.service.SpeaksService;

@Service("speaksService")
public class SpeaksServiceImpl implements SpeaksService {
	@Autowired
	private SpeaksMapper speaksMapper;

	@Override
	public PaginationBean<Speaks> listSpeaks(String speakman, String page, String rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		PaginationBean<Speaks> pBean = new PaginationBean<Speaks>();
		if (page != null) {
			pBean.setCurrPage(Integer.parseInt(page));
		}
		if (rows != null) {
			pBean.setPageSize(Integer.parseInt(rows));
		}
		map.put("speakman", speakman);
		map.put("pBean", pBean);
		return speaksMapper.PbeanSpeaks(map);
	}

	@Override
	public boolean add(Speaks speaks) {
		return speaksMapper.addSpeaks(speaks) > 0;
	}

	@Override
	public String findSid() {
		return speaksMapper.findSid();
	}

	@Override
	public Speaks findSpeaks(String sid, String speakman) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("sid", sid);
		map.put("speakman", speakman);
		return speaksMapper.findSpeaks(map);
	}

	public PaginationBean<Speaks> listAllSpeaks(String page, String rows) {
		PaginationBean<Speaks> pBean = new PaginationBean<Speaks>();
		if (page != null) {
			pBean.setCurrPage(Integer.parseInt(page));
		}
		if (rows != null) {
			pBean.setPageSize(Integer.parseInt(rows));
		}
		return speaksMapper.showSpeaks(pBean);
	}

	@Override
	public List<Speaks> findSpeaksInfoByName(Speaks speaks) {
		return speaksMapper.findByName(speaks);
	}

	@Override
	public List<Map<String,Object>> countSpeaks(String speakman) {
		return speaksMapper.countSpeaks(speakman);
	}

}
