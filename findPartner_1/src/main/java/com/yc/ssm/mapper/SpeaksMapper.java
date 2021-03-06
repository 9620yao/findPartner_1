package com.yc.ssm.mapper;

import java.util.List;
import java.util.Map;

import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Speaks;

public interface SpeaksMapper {

	/**
	 * 分页取到说说
	 * 
	 * @param map
	 * @return
	 */
	PaginationBean<Speaks> PbeanSpeaks(Map<String, Object> map);

	/**
	 * 添加说说
	 * 
	 * @param speaks
	 * @return
	 */
	int addSpeaks(Speaks speaks);

	/**
	 * 定制以及查总数
	 * @param speaks
	 * @return
	 */
	Speaks findSpeaks(Speaks speaks);

	String findSid();

	List<Speaks> findByName(Speaks speaks);

	List<Map<String, Object>> countSpeaks(String speakman);

}
