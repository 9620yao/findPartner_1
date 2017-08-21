package com.yc.ssm.mapper;

import java.util.List;
import java.util.Map;

import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Speaks;

public interface SpeaksMapper {

	/**
	 * 分页取到说说
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

	Speaks findSpeaks(Map<String, String> map);

	String findSid();

	List<Speaks> findByName(Speaks speaks);

	List<Map<String, Object>> countSpeaks(String speakman);

	List<Speaks> listSpeaks(String speakman);// 多余的测试查询

}
