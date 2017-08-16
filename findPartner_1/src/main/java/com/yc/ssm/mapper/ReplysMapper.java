package com.yc.ssm.mapper;

import java.util.List;

import com.yc.ssm.entity.Replys;

public interface ReplysMapper {

	/**
	 * 通过评论和回复编号取到回复
	 * @param rcid
	 * @return
	 */
	List<Replys> listreplys(String rcid);

	/**
	 * 添加回复
	 * @param replys
	 * @return
	 */
	int addReplys(Replys replys);

	/**
	 * 定制输出评论下的回复
	 * 
	 * @return
	 */
	List<Replys> getreplys();

	/**
	 * 定制输出回复下的回复
	 * 
	 * @return
	 */
	List<Replys> getRR();

}
