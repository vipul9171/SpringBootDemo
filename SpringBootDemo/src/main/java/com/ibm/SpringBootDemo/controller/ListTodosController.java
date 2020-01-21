package com.ibm.SpringBootDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ibm.SpringBootDemo.service.TodDoService;

@Controller
public class ListTodosController 
{

	@Autowired
	TodDoService todoService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String reterieveToDoList(ModelMap map) {

		map.put("list", todoService.reteriveTodos("vipul"));
		return "listView";
	}

}
