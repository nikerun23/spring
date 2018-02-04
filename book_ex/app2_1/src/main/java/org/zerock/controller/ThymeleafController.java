package org.zerock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {

	@RequestMapping("/listTest")
	public void sendData(Model model) {
		
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < 20; i++) {
			list.add("DATA : " + i);
		}
		
		model.addAttribute("name", "Sample Data");
		model.addAttribute("list", list);
	}
}
