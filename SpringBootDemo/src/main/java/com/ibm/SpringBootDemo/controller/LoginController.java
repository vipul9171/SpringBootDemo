package com.ibm.SpringBootDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ibm.SpringBootDemo.service.LoginService;
import com.ibm.SpringBootDemo.service.TodDoService;

@Controller
@SessionAttributes("username")
public class LoginController {
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPage(@RequestParam String username, @RequestParam String password, ModelMap map) {
		if (!loginService.isValid(username, password)) {
			map.put("errorMessage", "Invalide Credentials");
			return "login";
		}

		map.put("username", username);
		return "welcome";

	}

}
