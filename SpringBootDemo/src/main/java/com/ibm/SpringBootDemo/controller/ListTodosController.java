package com.ibm.SpringBootDemo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ibm.SpringBootDemo.service.TodDoService;

@Controller
@SessionAttributes("username")
public class ListTodosController {

	@Autowired
	TodDoService todoService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String reterieveToDoList(ModelMap map) {

		map.put("list", todoService.reteriveTodos((String) map.getAttribute("username")));
		map.put("username", (String) map.getAttribute("username"));
		return "listView";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String addintoToDoList(ModelMap map) {
		return "addTodo";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addTodoList(@RequestParam String desciption, ModelMap map) {
		System.out.println("this is here");
		todoService.addToDos(103, (String) map.getAttribute("username"), desciption, new Date(), false);
		return "Values Added Successfully";

	}

}
