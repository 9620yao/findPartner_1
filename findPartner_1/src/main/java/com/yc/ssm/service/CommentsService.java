package com.yc.ssm.service;

import java.util.List;

import com.yc.ssm.entity.Comments;

public interface CommentsService {

	List<Comments> listComments(String callid);

	void addComments(Comments comments);

}
