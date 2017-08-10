package com.yc.ssm.web.handler;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yc.ssm.entity.Album;
import com.yc.ssm.entity.Albumpic;
import com.yc.ssm.service.AlbumService;
import com.yc.ssm.service.AlbumpicService;
import com.yc.ssm.service.HomepageService;
import com.yc.ssm.util.ServletUtil;

@Controller("albumpicHandler")
@RequestMapping("albumpic")
public class AlbumpicHandler {

	@Autowired
	private AlbumpicService albumpicService;

	@Autowired
	private AlbumService albumService;

	@Autowired
	private HomepageService homepageService;

	@RequestMapping("list")
	@ResponseBody
	public List<Albumpic> listAlbumpic(HttpSession session) {
		String abid = (String) session.getAttribute(ServletUtil.ALBUMABID);
		LogManager.getLogger().debug(" listAlbumpic()进来了.....,abid: " + abid);
		return albumpicService.listApic(abid);
	}

	@RequestMapping(value = "newpic", method = RequestMethod.POST)
	@Transactional
	public String newpic(@RequestParam("picData") MultipartFile picData, @RequestParam("strpic") String strpic,
			HttpSession session) {
		String abid = (String) session.getAttribute(ServletUtil.ALBUMABID);
		LogManager.getLogger().debug(" listAlbumpic()进来了.....,abid: " + abid + ",strpic=" + strpic);
		String picPath = null;
		if (picData != null && !picData.isEmpty()) {
			try {
				picData.transferTo(ServletUtil.getUploadFile(picData.getOriginalFilename()));
				picPath = ServletUtil.VIRTUAL_UPLOAD_DIR + "/" + picData.getOriginalFilename();
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			LogManager.getLogger().debug("上传图片==》" + picPath);
			// 取到系统时间
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			String date = df.format(new Date());// new Date()为获取当前系统时间
			if (albumpicService.newpic(abid, picPath, date)) {// 添加成功
				Album Album = albumService.fpByabid(abid);// 根据相册编号去取该相册
				if (Album != null) {
					// 把该图片的相册编号，以及用户编号，还有图片上传时间存到主页表中
					homepageService.addhompage(abid, Album.getAaid(), date);
					String aheader = Album.getAheader();
					// 当刚上传的图片的相册没有头图片的话上传该图片为相册头图片
					if (aheader == null) {
						albumService.updateAheader(abid, picPath);
					}
				}
				return "redirect:" + strpic.split("/findPartner")[1];
			}
		}
		return "redirect:" + strpic.split("/findPartner")[1];
	}

	@RequestMapping("hpalbumpic")
	@ResponseBody
	public Albumpic HpAlbumpic(String abid, String apicdate, HttpSession session) {
		LogManager.getLogger().debug(" listAlbumpic()进来了.....,abid: " + abid + ",apicdate:" + apicdate);
		return albumpicService.HpAlbumpic(abid, apicdate);
	}

	@RequestMapping("fByabid")
	@ResponseBody
	public boolean findAlbumpic(String abid, HttpSession session) {
		LogManager.getLogger().debug(" listAlbumpic()进来了.....,abid: " + abid);
		return albumpicService.findAlbumpic(abid);
	}

}
