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
	
	@GetMapping("/adminForm/modifyUsers/findAllUsers")
	public String findAll(Model model) {
			
		model.addAttribute("users", userService.findAll());
		
		return "/user/findAllUsers";
	}
	
	@GetMapping("/adminForm/modifyUsers")
	public String modifyUsers() {
		
		return "/user/modifyUsers";
	}

	@GetMapping("/adminForm/modifyUsers/createUserWithRole")
	public String createUserWithRole() {
				
		return "/user/createUserWithRole";
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
		
		if(userService.findByRole("admin") == null) {
			userService.setRoleDataBase("admin", email);
		}
		else {
			userService.setRoleDataBase("client", email);
		}
		
		if(fullName != null) {
			userService.setFullNameDataBase(fullName, email);
		}
				
		return "/administrator/successForm";
	}
		
	@PostMapping("/modifyUsers/createUserWithRole")
	public String save(@RequestParam String email, String password, String fullName, String role) {

		if(email.isBlank() || email.isEmpty() || email == null || password.isBlank() || password.isEmpty() || password == null || userService.findByEmail(email) != null) {
			
			return "/administrator/unSuccessForm";
		}
				
		User user = new User(email, password);
		
		if(role == "admin")
			user.setRole(role);
		else
			user.setRole("client");
			
		if(fullName != null) {
			user.setFullName(fullName);
		}
		
		userService.save(user);
		
//		if(role == "admin")
//			userService.setRoleDataBase(role, email);
//		else
//			userService.setRoleDataBase("client", email);
//				
//		if(fullName != null) {
//			userService.setFullNameDataBase(fullName, email);
//		}
				
		return "/administrator/successForm";
	}

}
