package com.example.demo.controllers;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.services.UserService;

@Controller
public class AdminController {
	
	@Inject	
	private UserService userService;
	
	@PostMapping("/adminForm")
	public String getAdminForm(@RequestParam String email, String password, HttpSession httpSession) {
		
		userService.findByName(email, password);
		
		return "/administrator/adminForm";
	}
	
}
