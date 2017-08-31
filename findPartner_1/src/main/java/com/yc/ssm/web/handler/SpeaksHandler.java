package com.yc.ssm.web.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Speaks;
import com.yc.ssm.service.SpeaksService;
import com.yc.ssm.util.ServletUtil;

@Controller("speaksHandler")
@RequestMapping("speaks")
public class SpeaksHandler {
	@Autowired
	private SpeaksService speaksService;

	/**
	 * 分页显示说说,记得把后面显示说说，修改该请求中来
	 * 
	 * @param faid
	 *            用户编号
	 * @param currPage
	 *            当前页
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public PaginationBean<Speaks> listSpeaks(String faid, Integer currPage, HttpServletRequest request) {
		LogManager.getLogger().debug("我进来了 listSpeaks==>currPage=" + currPage + ",faid=" + faid);
		return speaksService.listSpeaks(faid, String.valueOf(currPage), "5");
	}

	/**
	 * 添加说说
	 * 
	 * 
	 * @param speaks
	 *            说说发表人
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.POST)
	@Transactional
	@ResponseBody
	public boolean add(@PathVariable("id") int id, Speaks speaks, HttpSession session) {
		LogManager.getLogger().debug("add ==要插入一条说说:" + speaks + ",id=" + id);
		String speakman = (String) session.getAttribute(ServletUtil.USERAID);// 从session中取到用户编号（说说发表人）
		speaks.setSpeakman(speakman);// 将说说发表人存到speak对象中
		if (speaksService.add(speaks)) {// 添加说说成功
			return true;
		}
		return false;
	}

	@RequestMapping(value = "hpspeaks", method = RequestMethod.POST)
	@ResponseBody
	public Speaks HomePageSpeaks(Speaks speaks, HttpServletRequest request) {
		LogManager.getLogger().debug("我进来了 listSpeaks==>speaks=" + speaks);
		return speaksService.findSpeaks(speaks);
	}

	@RequestMapping(value = "findunclear", method = RequestMethod.POST)
	@ResponseBody
	public List<Speaks> findByUnclearNames(Speaks speaks) {
		speaks.setSenddate(speaks.getSpeakman());
		speaks.setSpeakman(speaks.getSpeakman());
		return speaksService.findSpeaksInfoByName(speaks);
	}

	/**
	 * 取到该说说的总数，可以在分页取数据的时候，返回总数到页面，后期调整
	 * 
	 * @param speakman
	 *            说说发表人，及用户编号
	 * @return
	 */
	@RequestMapping(value = "countSpeaks", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> countSpeaks(String speakman) {
		LogManager.getLogger().debug("我进来了countSpeaks：" + speakman);
		return speaksService.countSpeaks(speakman);
	}

	@RequestMapping(value = "findunclearing", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> findByUnclearNames(String speakman) {
		return speaksService.countSpeaks(speakman);
	}

}
