package com.yc.ssm.mapper;

import java.util.List;
import java.util.Map;

import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Words;

public interface WordsMapper {
	// 增加留言
	int addWords(Words words);

	// 分页加载留言
	PaginationBean<Words> PbeanWords(Map<String, Object> map);

	PaginationBean<Words> showWords(PaginationBean<Words> pb);

	List<Words> findByName(Words Words);
	
	List<Map<String,Object>> countWords(String waid);

}
