package com.yc.ssm.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.ssm.entity.Aress;
import com.yc.ssm.mapper.AressMapper;
import com.yc.ssm.service.AressService;

@Service("aressService")
public class AressServiceImpl implements AressService {

	@Autowired
	private AressMapper aressMapper;

	@Override
	public boolean insertAs(Aress aress) {
		return aressMapper.insertAs(aress) > 0;
	}

	@Override
	public Map<String, Object> isAress(Aress aress) {
		Map<String, Object> map = new HashMap<String, Object>();
		aress = aressMapper.isAress(aress);
		if (aress == null || aress.equals("")) {
			map.put("idAress", true);
			return map;// 不存在，则添加
		}
		map.put("idAress", false);
		map.put("asid", aress.getAsid());
		return map;// 存在，则不添加
	}

}
