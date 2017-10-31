package org.zerock.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {

	private static Logger logger = LoggerFactory.getLogger(SampleController4.class);
	
	@RequestMapping("doE")
	public String doE(RedirectAttributes rttr) {
		logger.info("doE called redirect............");
		
		rttr.addFlashAttribute("msg", "This the Massage!! with redirected!!");
		return "redirect:/doF";
	}
	
	@RequestMapping("doF")
	public String doF(RedirectAttributes rttr) {
		logger.info("doF called............");
		
		return "result";
	}
	
}
