package com.yc.ssm.service;

import java.util.List;
import java.util.Map;

import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Words;

public interface WordsService {

	// List<Words> findWords(Words words);

	void add(Words words);

	PaginationBean<Words> listWords(String waid, String page, String rows);

	PaginationBean<Words> listAllWords(String page, String rows);

	List<Words> findWordsInfoByName(Words words);

	List<Map<String, Object>> countWords(String waid);

}
