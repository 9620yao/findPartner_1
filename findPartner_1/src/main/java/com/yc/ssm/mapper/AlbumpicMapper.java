package com.yc.ssm.mapper;

import java.util.List;

import com.yc.ssm.entity.Albumpic;

public interface AlbumpicMapper {

	List<Albumpic> listApic(Albumpic albumpic);

	int addpic(Albumpic albumpic);

	Albumpic HpAlbumpic(Albumpic albumpic);

}
