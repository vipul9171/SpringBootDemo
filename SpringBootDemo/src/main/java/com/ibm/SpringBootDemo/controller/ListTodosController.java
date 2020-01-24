package com.ibm.SpringBootDemo.controller;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ibm.SpringBootDemo.model.TodoModel;
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
	public String showTodo(ModelMap model) {
		// model.addAllAttributes("todoModel",(String) map.getAttribute("username"),"",
		// new Date(), false);
		model.addAttribute("todoModel",
				new TodoModel(0, (String) model.getAttribute("username"), "", new Date(), false));

		return "addTodo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodoList(ModelMap map,TodoModel todoModel) {

		// todoService.addToDos((String) map.getAttribute("username"),
		// todoModel.getDesc(), new Date(), false);
		System.out.println("this is " + todoModel.getDesc());
		todoService.addToDos((String) map.getAttribute("username"), todoModel.getDesc(), new Date(), false);
		return "redirect:/list";

	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodoList(@RequestParam int id) {

		todoService.deleteToDos(id);
		return "redirect:/list";

	}

}
