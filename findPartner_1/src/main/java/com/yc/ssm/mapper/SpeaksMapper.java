package com.yc.ssm.mapper;

import java.util.List;
import java.util.Map;

import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Speaks;

public interface SpeaksMapper {

	PaginationBean<Speaks> PbeanSpeaks(Map<String, Object> map);
	PaginationBean<Speaks> showSpeaks(PaginationBean<Speaks> pb);

	// List<Speaks> findSpeaks(String speakman);

	// 增加说说
	int addSpeaks(Speaks speaks);

	Speaks findSpeaks(Map<String, String> map);

	String findSid();
	
	List<Speaks> findByName(Speaks speaks);
	
	List<Map<String,Object>> countSpeaks(String speakman);
	
}
