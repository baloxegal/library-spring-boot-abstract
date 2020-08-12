package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
	
	@PostMapping("/adminForm")
	public String getAdminForm() {
		
		return "/administrator/adminForm";
	}
	
}
