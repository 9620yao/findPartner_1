package com.yc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.ssm.entity.Albumpic;
import com.yc.ssm.mapper.AlbumpicMapper;
import com.yc.ssm.service.AlbumpicService;

@Service("albumpicService")
public class AlbumpicServiceImpl implements AlbumpicService {

	@Autowired
	private AlbumpicMapper albumpicMapper;

	@Override
	public List<Albumpic> listApic(Albumpic albumpic) {
		return albumpicMapper.listApic(albumpic);
	}

	@Override
	public boolean add(Albumpic albumpic) {
		return albumpicMapper.addpic(albumpic) > 0;
	}

	@Override
	public Albumpic HpAlbumpic(Albumpic albumpic) {
		return albumpicMapper.HpAlbumpic(albumpic);
	}

	@Override
	public boolean findAlbumpic(Albumpic albumpic) {
		List<Albumpic> list = albumpicMapper.listApic(albumpic);
		if (list != null && list.size() > 0) {
			return true;// 该相册下有图片
		}
		return false;
	}

}
