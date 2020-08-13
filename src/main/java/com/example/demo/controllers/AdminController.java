package com.example.demo.controllers;

import javax.inject.Inject;
//import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.User;
import com.example.demo.services.UserService;

@Controller
public class AdminController {
	
	@Inject	
	private UserService userService;
	
	@GetMapping("/adminForm")
	public String getAdminForm() {
		
		return "/administrator/adminForm";
	}
	
	@PostMapping("/adminForm")
	public String getAdminForm(@RequestParam String email, String password) {
		
		User user = userService.login(email, password);
		
		if(user != null)
			return "/administrator/successForm";
		else
			return "/administrator/unSuccessForm";
	}

}
