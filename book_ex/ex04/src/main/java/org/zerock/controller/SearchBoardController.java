package org.zerock.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.PageMaker;
import org.zerock.domain.SearchCriteria;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {

	private final static Logger logger = LoggerFactory.getLogger(SearchBoardController.class);

	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri
			, Model model)throws Exception {
		
		logger.info(cri.toString());
		
		model.addAttribute("list", service.listSearchCriteria(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));
		
		model.addAttribute(pageMaker);
	}
	
	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void readPage(@ModelAttribute("cri") SearchCriteria cri
			, @RequestParam("bno") int bno
			, Model model)throws Exception {
		
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value = "/removePage", method = RequestMethod.GET)
	public String removePage(@RequestParam("bno") int bno
			, SearchCriteria cri
			, RedirectAttributes rttr)throws Exception {
		
		service.remove(bno);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/sboard/list";
	}
	
	@RequestMapping( value = "/modifyPage", method = RequestMethod.GET)
	public void modifyPageGet(@RequestParam("bno") int bno
			, @ModelAttribute("cri") SearchCriteria cri
			, Model model)throws Exception {
		
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagePost(BoardVO boardVO
			, SearchCriteria cri
			, RedirectAttributes rttr)throws Exception {
		
		logger.info(cri.toString());
		
		service.modify(boardVO);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		rttr.addFlashAttribute("msg", "success");
		logger.info(rttr.toString());
		return "redirect:/sboard/list";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGet() {
		logger.info("register GET ...........");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPost(BoardVO boardVO
			, RedirectAttributes rttr)throws Exception {
		logger.info("register POST ...........");
		
		service.regist(boardVO);
		
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/sboard/list";
	}
	
	@RequestMapping("/getAttach/{bno}")
	@ResponseBody
	public List<String> getAttach(@PathVariable("bno") Integer bno)throws Exception {
		
		return service.getAttach(bno);
	}
}
