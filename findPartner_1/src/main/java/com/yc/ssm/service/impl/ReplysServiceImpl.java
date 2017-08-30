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
	public List<Replys> listreplys(Replys replys) {
		return replysMapper.getreplys(replys);
	}

	@Override
	public boolean addReplys(Replys replys) {
		return replysMapper.addReplys(replys)>0;
	}

}
