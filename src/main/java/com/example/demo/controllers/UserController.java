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
	
	@GetMapping("/adminForm/modifyUsers/users")
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

		if(email.isBlank() || email.isEmpty() || email == null || password.isBlank() || password.isEmpty() || password == null || userService.findByEmail(email) != null) {
			
			return "/administrator/unSuccessForm";
		}
				
		User user = new User(email, password);
		
		userService.save(user);
		
		if(userService.findRole("admin") == null) {
			userService.setRole("admin", email);
		}
		else {
			userService.setRole("client", email);
		}
		
		if(fullName != null) {
			userService.setFullName(fullName, email);
		}
				
		return "/administrator/successForm";
	}
	
	@PostMapping("authorizationForm/adminForm/modifyUsers/createUserWithRole")
	public String save(@RequestParam String email, String password, String fullName, String role) {

		if(email.isBlank() || email.isEmpty() || email == null || password.isBlank() || password.isEmpty() || password == null || userService.findByEmail(email) != null) {
			
			return "/administrator/unSuccessForm";
		}
				
		User user = new User(email, password);
		
		userService.save(user);
		
		userService.setRole("admin", email);
				
		if(fullName != null) {
			userService.setFullName(fullName, email);
		}
				
		return "/administrator/successForm";
	}

}
