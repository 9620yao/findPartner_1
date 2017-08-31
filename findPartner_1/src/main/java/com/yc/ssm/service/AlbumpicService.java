package com.yc.ssm.service;

import java.util.List;

import com.yc.ssm.entity.Albumpic;

public interface AlbumpicService {

	List<Albumpic> listApic(Albumpic albumpic);// 取到相册下的图片

	boolean add(Albumpic albumpic);

	Albumpic HpAlbumpic(Albumpic albumpic);

	boolean findAlbumpic(Albumpic albumpic);

}
