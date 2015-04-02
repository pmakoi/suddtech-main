package com.suddtech.easyshop.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.suddtech.easyshop.model.User;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}

	@RequestMapping("/newaccount")
	public String showNewAcount(Model model) {
		model.addAttribute("user", new User());
		return "newaccount";
	}

	@RequestMapping("/createaccount")
	public String createAcount() {
		return "accountcreated";
	}
}
