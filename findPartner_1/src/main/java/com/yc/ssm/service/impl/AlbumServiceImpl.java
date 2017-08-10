package com.yc.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.ssm.entity.Album;
import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.mapper.AlbumMapper;
import com.yc.ssm.service.AlbumService;

@Service("albumService")
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	private AlbumMapper albumMapper;

	@Override
	public List<Album> listAlbum(String aaid) {
		return albumMapper.listAlbum(aaid);
	}

	@Override
	public boolean addAlbum(Album album) {
		return albumMapper.addAlbum(album) > 0;
	}

	@Override
	public Album fpByabid(String abid) {
		return albumMapper.fpByabid(abid);
	}

	@Override
	public boolean updateAheader(String abid, String picPath) {
		Map<String,String> map  = new HashMap<String,String>();
		map.put("abid", abid);
		map.put("picPath", picPath);
		return albumMapper.updateAheader(map)>0;
	}

	@Override
	public void updateAldate(String abid,String aldate) {
		Map<String,String> map  = new HashMap<String,String>();
		map.put("abid", abid);
		map.put("aldate", aldate);
		albumMapper.updateAldate(map);
	}

	@Override
	public PaginationBean<Album> listAllAlbums(String page, String rows) {
		PaginationBean<Album> pBean=new PaginationBean<Album>();
		if(page!=null){
			pBean.setCurrPage(Integer.parseInt(page));
		}
		if(rows!=null){
			pBean.setPageSize(Integer.parseInt(rows));
		}
		return albumMapper.showAlbum(pBean);
	}

	@Override
	public List<Album> findAlbumInfoByName(Album album) {
		return albumMapper.findByName(album);
	}

	@Override
	public List<Map<String, Object>> countAlbum(String aaid) {
		return albumMapper.countAlbum(aaid);
	}

}
