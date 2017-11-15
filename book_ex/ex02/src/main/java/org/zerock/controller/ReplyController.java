package org.zerock.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.service.ReplyService;

@RestController
@RequestMapping("/replies/*")
public class ReplyController {

	@Inject
	private ReplyService service;
	
	//@RequestMapping(value = "/all", method = RequestMethod.GET)
	
	
}
