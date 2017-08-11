package com.yc.ssm.web.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.ssm.entity.Album;
import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.service.AlbumService;
import com.yc.ssm.util.ServletUtil;

@Controller("albumHandler")
@RequestMapping("album")
public class AlbumHandler {

	@Autowired
	private AlbumService albumService;

	/**
	 * 显示相册
	 * 
	 * @param faid当前用户
	 * @param session
	 * @return
	 */
	@RequestMapping("list")
	@ResponseBody
	public List<Album> list(String faid, HttpSession session) {
		LogManager.getLogger().debug("我是Album list() 我进来了 ,faid=" + faid);
		return albumService.listAlbum(faid);
	}

	/**
	 * 添加相册
	 * @param strimg
	 * @param Album
	 * @param session
	 * @return
	 */
	@RequestMapping("newimgs")
	public String NewImgs(@RequestParam("strimg") String strimg, Album Album, HttpSession session) {
		String auid = (String) session.getAttribute(ServletUtil.USERAID);
		LogManager.getLogger().debug("我是Album list() 我进来了 aaid:" + auid);
		Album.setAuid(auid);
		albumService.addAlbum(Album);
		return "redirect:" + strimg.split("/findPartner")[1];
	}

	@RequestMapping(value = "showAlbums", method = RequestMethod.POST)
	@ResponseBody
	public PaginationBean<Album> showAllAlbums(String page, String rows) {
		LogManager.getLogger().debug("我进来了 showAllAlbums==>currPage=" + page);
		return albumService.listAllAlbums(page, rows);
	}

	/**
	 * 
	 * @param album
	 * @return
	 */
	@RequestMapping(value = "findunclear", method = RequestMethod.POST)
	@ResponseBody
	public List<Album> findByUnclearNames(Album album) {
		album.setAuid(album.getAuid());
		album.setAldate(album.getAuid());
		return albumService.findAlbumInfoByName(album);
	}

	@RequestMapping(value = "countAlbum", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> countAlbum(String aaid) {
		LogManager.getLogger().debug("我进来了countSpeaks：" + aaid);
		return albumService.countAlbum(aaid);
	}

	@RequestMapping(value = "findunclearing", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> findByUnclearNames(String aaid) {
		return albumService.countAlbum(aaid);
	}

}
