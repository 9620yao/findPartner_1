package com.yc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.ssm.entity.Replys;
import com.yc.ssm.mapper.ReplysMapper;
import com.yc.ssm.service.ReplysService;

@Service("replysService")
public class ReplysServiceImpl implements ReplysService {

	@Autowired
	private ReplysMapper replysMapper;
	
	@Override
	public List<Replys> listreplys(String listrcid) {
		return replysMapper.listreplys(listrcid);
	}

	@Override
	public void addReplys(Replys replys) {
		replysMapper.addReplys(replys);
	}

}
