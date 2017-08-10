package com.yc.ssm.mapper;

import java.util.List;

import com.yc.ssm.entity.Comments;

public interface CommentsMapper {

	List<Comments> listComments(String callid);

	int addComments(Comments comments);

}
