package com.yc.ssm.service;

import java.util.List;

import com.yc.ssm.entity.Comments;

public interface CommentsService {

	List<Comments> listComments(Comments comments);

	boolean addComments(Comments comments);

}
