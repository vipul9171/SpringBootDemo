package com.ibm.SpringBootDemo.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

	public boolean isValid(String username, String password) {
		return username.equalsIgnoreCase("vipul") && password.equalsIgnoreCase("vipul");
	}

}
