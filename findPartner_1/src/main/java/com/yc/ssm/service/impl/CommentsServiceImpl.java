package com.yc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.ssm.entity.Comments;
import com.yc.ssm.mapper.CommentsMapper;
import com.yc.ssm.service.CommentsService;

@Service("commentsService")
public class CommentsServiceImpl implements CommentsService {

	@Autowired
	private CommentsMapper commentsMapper;
	
	@Override
	public List<Comments> listComments(String callid) {
		return commentsMapper.listComments(callid);
	}

	@Override
	public void addComments(Comments comments) {
		commentsMapper.addComments(comments);
	}

}
