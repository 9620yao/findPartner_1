package com.yc.ssm.web.handler;

import java.io.File;
import java.io.IOException;
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

import com.yc.ssm.entity.Albumpic;
import com.yc.ssm.service.AlbumpicService;
import com.yc.ssm.util.ServletUtil;

import net.coobird.thumbnailator.Thumbnails;

@Controller("albumpicHandler")
@RequestMapping("albumpic")
public class AlbumpicHandler {

	@Autowired
	private AlbumpicService albumpicService;

	@RequestMapping("list")
	@ResponseBody
	public List<Albumpic> listAlbumpic(Albumpic albumpic, HttpSession session) {
		String abid = (String) session.getAttribute(ServletUtil.ALBUMABID);
		LogManager.getLogger().debug(" listAlbumpic()进来了.....,abid: " + abid);
		albumpic.setAbid(abid);
		return albumpicService.listApic(albumpic);
	}

	/**
	 * 图片添加，未修改。
	 * 
	 * @param picData
	 * @param strpic
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	public boolean add(@RequestParam("picData") MultipartFile picData, Albumpic albumpic, HttpSession session) {
		String abid = (String) session.getAttribute(ServletUtil.ALBUMABID);
		String uid = (String) session.getAttribute(ServletUtil.USERAID);
		LogManager.getLogger().debug(" listAlbumpic()进来了.....,abid: " + abid+",uid="+uid+",picData"+picData);
		String picPath = null;
		File dest = null;
		if (picData != null && !picData.isEmpty()) {
			try {
				dest = ServletUtil.getUploadFile(picData.getOriginalFilename());
				// 压缩图片并上传
				Thumbnails.of(picData.getInputStream()).scale(1f).outputQuality(0.25f).toFile(dest);
				picPath = ServletUtil.VIRTUAL_UPLOAD_DIR + "/" + picData.getOriginalFilename();
			} catch (Exception e) {
				try {
					picData.transferTo(dest);
				} catch (IllegalStateException | IOException e1) {
					e1.printStackTrace();
				}
			}
			LogManager.getLogger().debug("上传图片地址==》" + picPath);
			albumpic.setApic(picPath);
			albumpic.setAbid(abid);
			albumpic.setUid(uid);
			return albumpicService.add(albumpic);
		}
		return false;
	}

	@RequestMapping("hpalbumpic")
	@ResponseBody
	public Albumpic HpAlbumpic(Albumpic albumpic, HttpSession session) {
		LogManager.getLogger().debug(" listAlbumpic()进来了.....,albumpic: " + albumpic);
		return albumpicService.HpAlbumpic(albumpic);
	}

	@RequestMapping("fByabid")
	@ResponseBody
	public boolean findAlbumpic(Albumpic albumpic, HttpSession session) {
		LogManager.getLogger().debug(" listAlbumpic()进来了.....,albumpic: " + albumpic);
		return albumpicService.findAlbumpic(albumpic);
	}

}
