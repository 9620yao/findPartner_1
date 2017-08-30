package com.yc.ssm.mapper;

import java.util.List;

import com.yc.ssm.entity.Replys;

public interface ReplysMapper {

	/**
	 * 添加回复
	 * 
	 * @param replys
	 * @return
	 */
	int addReplys(Replys replys);

	/**
	 * 定制输出评论下的回复
	 * 
	 * @return
	 */
	List<Replys> getreplys(Replys replys);


}
