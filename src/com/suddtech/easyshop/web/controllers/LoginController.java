package com.suddtech.easyshop.web.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suddtech.easyshop.dao.util.FormValidationGroup;
import com.suddtech.easyshop.model.Message;
import com.suddtech.easyshop.model.User;
import com.suddtech.easyshop.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}

	@RequestMapping("/denied")
	public String showDenied() {
		return "denied";
	}

//	@RequestMapping("/messages")
//	public String getMessages() {
//		return "messages";
//	}

	@RequestMapping("/admin")
	public String showAdmin(Model model) {

		List<User> users = userService.getAllUsers();

		model.addAttribute("users", users);

		return "admin";
	}

	@RequestMapping("/loggedout")
	public String showLoggedOut() {
		return "loggedout";
	}

	@RequestMapping("/newaccount")
	public String showNewAcount(Model model) {
		model.addAttribute("user", new User());
		return "newaccount";
	}

	@RequestMapping(value = "/createaccount", method = RequestMethod.POST)
	public String createAccount(
			@Validated(FormValidationGroup.class) User user,
			BindingResult result) {

		if (result.hasErrors()) {
			return "newaccount";
		}

		user.setAuthority("ROLE_USER");
		user.setEnabled(true);

		userService.createUser(user);

		return "accountcreated";
	}

	@RequestMapping(value = "/getmessages", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Map<String, Object> getMessages(Principal principal) {
		List<Message> messages = null;
		if (principal == null) {
			messages = new ArrayList<Message>();
		} else {
			String username = principal.getName();
			messages = userService.getMessages(username);

		}
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("messages", messages);
		data.put("number", messages.size());
		return data;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//@RequestMapping(value = "/getmessages", method = RequestMethod.GET, produces = "application/json")
	@RequestMapping("/messages")
//	@ResponseBody
	public String getMessages(Model model,Principal principal) {
		List<Message> messages = null;
		if (principal == null) {
			messages = new ArrayList<Message>();
		} else {
			String username = principal.getName();
			messages = userService.getMessages(username);

		}
		model.addAttribute("messages",messages);
		return "messages";
	}

}
