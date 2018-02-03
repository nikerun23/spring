package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test(Model model) {
		
		model.addAttribute("msg", "Hello World !!");
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public String testPOST(String username, String address, Model model) {
		
		System.out.println("USERNAME : " + username);
		System.out.println("ADDRESS : " + address);
		
		model.addAttribute("msg", "Hello World !!");
		
		return "resultSuccess";
	}
}
