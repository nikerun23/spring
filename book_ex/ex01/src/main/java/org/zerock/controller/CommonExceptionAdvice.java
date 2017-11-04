package org.zerock.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionAdvice {

	private static final Logger logger = Logger.getLogger(CommonExceptionAdvice.class);
/*	
	@ExceptionHandler(Exception.class)
	public String common(Exception e) {
		
		logger.info(e.toString());
		
		return "error_common";
	}
	*/
	@ExceptionHandler(Exception.class)
	public ModelAndView errorModelAndView(Exception ex) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error_common");
		modelAndView.addObject("exception", ex);
		
		return modelAndView;
	}
}
