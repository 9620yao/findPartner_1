package com.yc.ssm.mapper;

import java.util.List;
import java.util.Map;

import com.yc.ssm.entity.Album;
import com.yc.ssm.entity.PaginationBean;

public interface AlbumMapper {

	List<Album> listAlbum(String aaid);

	int addAlbum(Album album);

	Album fpByabid(String abid);

	int updateAheader(Map<String, String> map);

	void updateAldate(Map<String, String> map);

	PaginationBean<Album> showAlbum(PaginationBean<Album> pBean);
	
	List<Album> findByName(Album album);
	
	List<Map<String,Object>> countAlbum(String aaid);


}
