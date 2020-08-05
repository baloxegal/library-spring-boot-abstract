package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@GetMapping("adminForm")
	public String getAdminForm() {
		
		return "administrator/adminForm";
	}
	
	@GetMapping("modifyBooks")
	public String modifyBooks() {
		
		return "administrator/modifyBooks";
	}
}
