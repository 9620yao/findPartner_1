package com.yc.ssm.service;

import java.util.List;

import com.yc.ssm.entity.Replys;

public interface ReplysService {

	List<Replys> listreplys(String listrcid);

	void addReplys(Replys replys);

}
