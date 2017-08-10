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

	@RequestMapping("list")
	@ResponseBody
	public List<Album> list(String faid, HttpSession session) {
		LogManager.getLogger().debug("我是Album list() 我进来了 ,faid=" + faid);
		return albumService.listAlbum(faid);
	}

	@RequestMapping("newimgs")
	public String NewImgs(@RequestParam("strimg") String strimg, Album Album, HttpSession session) {
		String aaid = (String) session.getAttribute(ServletUtil.FINALAID);
		LogManager.getLogger().debug("我是Album list() 我进来了 aaid:" + aaid);
		if (albumService.addAlbum(Album)) {
			return "redirect:" + strimg.split("/findPartner")[1];
		}
		return "redirect:/page/lw-log.jsp";// 取不到返回地址的时候 回到登录界面
	}

	@RequestMapping(value = "showAlbums", method = RequestMethod.POST)
	@ResponseBody
	public PaginationBean<Album> showAllAlbums(String page, String rows) {
		LogManager.getLogger().debug("我进来了 showAllAlbums==>currPage=" + page);
		return albumService.listAllAlbums(page, rows);
	}

	@RequestMapping(value = "findunclear", method = RequestMethod.POST)
	@ResponseBody
	public List<Album> findByUnclearNames(Album album) {
		album.setAaid(album.getAaid());
		album.setAldate(album.getAaid());
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
