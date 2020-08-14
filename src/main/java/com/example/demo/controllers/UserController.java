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

	@GetMapping("/createUser")
	public String createUser() {
				
		return "/user/createUser";
	}
	
	@PostMapping("/createUser")
	public String save(@RequestParam String email, String password, String fullName) {

		if(email.isBlank() || email.isEmpty() || email == null || password.isBlank() || password.isEmpty() || password == null || email == userService.findByName(email).getEmail()) {
			return "/administrator/unSuccessForm";
		}
				
		User user = new User(email, password);
		
		userService.save(user);
				
		if(userService.count() == 1) {
			userService.setRoleAdmin("admin", user.getEmail());
		}
		
		if(fullName != null) {
			userService.findByName(email).setFullName(fullName);
		}
		
		return "/administrator/successForm";
	}

}
