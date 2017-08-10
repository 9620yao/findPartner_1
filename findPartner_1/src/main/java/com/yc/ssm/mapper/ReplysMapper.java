package com.yc.ssm.mapper;

import java.util.List;

import com.yc.ssm.entity.Replys;

public interface ReplysMapper {

	List<Replys> listreplys(String rcid);

	int addReplys(Replys replys);

}
