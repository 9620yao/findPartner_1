package com.yc.ssm.mapper;

import java.util.List;

import com.yc.ssm.entity.Comments;

public interface CommentsMapper {

	int addComments(Comments comments);

	List<Comments> getcom(Comments comments);

}
