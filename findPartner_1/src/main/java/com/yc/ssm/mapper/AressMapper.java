package com.yc.ssm.mapper;

import com.yc.ssm.entity.Aress;

public interface AressMapper {

	/**
	 * 查询显示地址
	 * 
	 * @param aress
	 * @return
	 */
	Aress getas(Aress aress);

	/**
	 * 插入
	 * 
	 * @param aress
	 * @return
	 */
	int insertAs(Aress aress);

	/**
	 * 查询是否存在
	 * 
	 * @param aress
	 * @return
	 */
	Aress isAress(Aress aress);

}
