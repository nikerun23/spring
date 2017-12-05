package org.zerock.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.service.MessageService;

@RestController
@RequestMapping("/messages")
public class MessageController {

	@Inject
	private MessageService service;
	
}
