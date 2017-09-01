package com.yc.ssm.service;

import java.util.List;
import java.util.Map;

import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Words;

public interface WordsService {

	/**
	 * 添加留言
	 * @param words
	 * @return
	 */
	boolean add(Words words);

	PaginationBean<Words> listWords(String waid, String page, String rows);

	List<Words> findWordsInfoByName(Words words);

	List<Map<String, Object>> countWords(String waid);

}
