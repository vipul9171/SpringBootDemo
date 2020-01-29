package com.ibm.SpringBootDemo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller("error")
public class ErrorController {
	@ExceptionHandler(Exception.class)
	public ModelAndView handleExecetion(HttpServletRequest request, HttpServletResponse response, Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("error", e.getLocalizedMessage());
		mv.addObject("url",request.getRequestURL());
		mv.setViewName("error");
		return mv;
	}

}