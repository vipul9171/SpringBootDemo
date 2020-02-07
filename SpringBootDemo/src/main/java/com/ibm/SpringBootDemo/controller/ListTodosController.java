package com.ibm.SpringBootDemo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ibm.SpringBootDemo.model.TodoModel;
import com.ibm.SpringBootDemo.service.TodDoService;

@Controller
@SessionAttributes("username")
public class ListTodosController {

	@Autowired
	TodDoService todoService;

	@InitBinder
	public void initBinder(WebDataBinder bindingInitializer) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
		bindingInitializer.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String reterieveToDoList(ModelMap map) {

		System.out.println("List " + todoService.reteriveTodos(getLoggedInUser(map)));
		map.put("list", todoService.reteriveTodos(getLoggedInUser(map)));
		/* map.put("username", (String) map.getAttribute("username")); */
		return "listView";
	}

	private String getLoggedInUser(ModelMap map) {
		return (String) map.getAttribute("username");
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showTodo(ModelMap model) {
		model.addAttribute("todoModel", new TodoModel(0, getLoggedInUser(model), "", new Date(), false));

		return "addTodo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodoList(ModelMap map, @Valid TodoModel todoModel, BindingResult result) {

		if (result.hasErrors()) {
			return "addTodo";

		}
		todoService.addToDos(getLoggedInUser(map), todoModel.getDesc(), todoModel.getTargetDate(), false);
		return "redirect:/list";
		

	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodoList(@RequestParam int id) {

		todoService.deleteToDos(id);
		return "redirect:/list";

	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id, ModelMap model) {

		model.put("todoModel", todoService.reteriveTodoById(id));
		return "addTodo";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap map, @Valid TodoModel todoModel, BindingResult result) {

		if (result.hasErrors()) {
			return "addTodo";

		}
		todoModel.setUser(getLoggedInUser(map));

		todoService.updateTodo(todoModel);
		return "redirect:/list";

	}

}
