package com.yc.ssm.mapper;

import java.util.List;

import com.yc.ssm.entity.Albumpic;

public interface AlbumpicMapper {

	List<Albumpic> listApic(String abid);

	int addpic(Albumpic albumpic);

	Albumpic HpAlbumpic(Albumpic albumpic);

	List<Albumpic> findAlbumpic(String abid);

}
