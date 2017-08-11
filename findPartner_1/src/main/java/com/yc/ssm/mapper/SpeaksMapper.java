package com.yc.ssm.mapper;

import java.util.List;
import java.util.Map;

import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Speaks;

public interface SpeaksMapper {

	PaginationBean<Speaks> PbeanSpeaks(Map<String, Object> map);
	
	int addSpeaks(Speaks speaks);

	Speaks findSpeaks(Map<String, String> map);

	String findSid();
	
	List<Speaks> findByName(Speaks speaks);
	
	List<Map<String,Object>> countSpeaks(String speakman);
	
}
