package com.example.demo.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.User;
import com.example.demo.services.UserService;

@Controller
public class UserController {
	@Inject
	private UserService userService;
	
	@GetMapping("/users")
	public String findAll(Model model) {
			
		model.addAttribute("users", userService.findAll());
		
		return "/user/findAllUsers";
	}
	
	@GetMapping("/adminForm/modifyUsers")
	public String modifyUsers() {
		
		return "/user/modifyUsers";
	}

	@GetMapping("/adminForm/modifyUsers/createUser")
	public String createUser(Model model) {
				
		return "/user/createUser";
	}
	
	@PostMapping("/adminForm/modifyUsers/createUser")
	public String save(@RequestParam String email, String password) {

		if(email.isBlank() || email.isEmpty() || email == null || password.isBlank() || password.isEmpty() || password == null) {
			return "/administrator/unSuccessForm";
		}
		
		userService.save(new User(email, password));
		
		return "/administrator/successForm";
	}

}
