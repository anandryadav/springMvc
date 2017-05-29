package com.javamvc.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.javamvc.login.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService service;

	public LoginController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handelLoginRequest(ModelMap model, @RequestParam String name, @RequestParam String password) {
		if (!service.validateUser(name, password)) {
			model.put("errorMessage","Invaild user or password");
			return "login";
			
		}else{
			model.put("name", name);
			model.put("password", password);
			return "home";
		}
	}
}
