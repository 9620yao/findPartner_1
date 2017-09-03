package com.yc.ssm.service;

import java.util.Map;

import com.yc.ssm.entity.Aress;

public interface AressService {

	/**
	 * 添加
	 * 
	 * @param Aress
	 * @return
	 */
	boolean insertAs(Aress Aress);

	/**
	 * 判断该地址是否存在
	 * 
	 * @param Aress
	 * @return
	 */
	Map<String, Object> isAress(Aress Aress);
}
