package com.yc.ssm.web.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Words;
import com.yc.ssm.service.WordsService;
import com.yc.ssm.util.ServletUtil;

@Controller("wordsHandler")
@RequestMapping("words")
public class WordsHandler {
	@Autowired
	private WordsService wordsService;

	@RequestMapping("list")
	@ResponseBody
	public PaginationBean<Words> listWords(String faid, Integer currPage, String rows, HttpServletRequest request) {
		LogManager.getLogger().debug("我进来了 listWords,faid=" + faid);
		return wordsService.listWords(faid, String.valueOf(currPage), "5");
	}

	@RequestMapping(value = "showWords", method = RequestMethod.POST)
	@ResponseBody
	public PaginationBean<Words> showAllWords(String page, String rows) {
		LogManager.getLogger().debug("我进来了 showAllWords==>currPage=" + page);
		return wordsService.listAllWords(page, rows);
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addWords(@RequestParam("strword") String strword, Words words, HttpSession session) {
		LogManager.getLogger().debug("我进来了 addWords==>words:" + words);
		// 评论人为登录用户
		String wfrendid = (String) session.getAttribute(ServletUtil.USERAID);
		words.setWfrendid(wfrendid);
		wordsService.add(words);
		if (strword != null) {
			return "redirect:" + strword.split("/findPartner")[1];
		}
		return "redirect:/page/lw-log.jsp";
	}

	@RequestMapping(value = "findunclear", method = RequestMethod.POST)
	@ResponseBody
	public List<Words> findByUnclearNames(Words words) {
		words.setWfrendid(words.getWfrendid());
		words.setWdate(words.getWfrendid());
		return wordsService.findWordsInfoByName(words);
	}
	
	@RequestMapping(value = "countWords", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> countAllWord(String waid) {
		LogManager.getLogger().debug("我进来了countAllWord：" + waid);
		return wordsService.countWords(waid);
	}
	
	@RequestMapping(value = "findunclearing", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> findByUnclearNames(String waid) {
		return wordsService.countWords(waid);	
	}

}
