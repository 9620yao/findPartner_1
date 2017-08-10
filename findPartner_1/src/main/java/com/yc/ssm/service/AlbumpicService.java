package com.yc.ssm.service;

import java.util.List;

import com.yc.ssm.entity.Albumpic;

public interface AlbumpicService {

	List<Albumpic> listApic(String abid);// 取到相册下的图片

	boolean newpic(String abid, String picPath, String date);

	Albumpic HpAlbumpic(String abid, String apicdate);

	boolean findAlbumpic(String abid);

}
