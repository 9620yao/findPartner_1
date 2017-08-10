package com.yc.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Speaks;
import com.yc.ssm.entity.Words;
import com.yc.ssm.mapper.WordsMapper;
import com.yc.ssm.service.WordsService;

@Service("wordsService")
public class WordsServiceImpl implements WordsService {
	
	@Autowired
	private WordsMapper wordsMapper;
	
	public void setWordsMapper(WordsMapper wordsMapper) {
		this.wordsMapper = wordsMapper;
	}

	@Override
	public void add(Words words) {
		wordsMapper.addWords(words);
	}

	@Override
	public PaginationBean<Words> listWords(String waid, String page, String rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		PaginationBean<Speaks> pBean = new PaginationBean<Speaks>();
		if (page != null) {
			pBean.setCurrPage(Integer.parseInt(page));
		}
		if (rows != null) {
			pBean.setPageSize(Integer.parseInt(rows));
		}
		map.put("waid", waid);
		map.put("pBean", pBean);
		return wordsMapper.PbeanWords(map);
	}

	@Override
	public PaginationBean<Words> listAllWords(String page, String rows) {
		PaginationBean<Words> pBean=new PaginationBean<Words>();
		if(page!=null){
			pBean.setCurrPage(Integer.parseInt(page));
		}
		if(rows!=null){
			pBean.setPageSize(Integer.parseInt(rows));
		}
		return wordsMapper.showWords(pBean);
	}

	@Override
	public List<Words> findWordsInfoByName(Words words) {
		return wordsMapper.findByName(words);
	}

	@Override
	public List<Map<String, Object>> countWords(String waid) {
		return wordsMapper.countWords(waid);
	}
}
