package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	@RequestMapping("/adminForm")
	public String getAdminForm() {
		
		return "/administrator/adminForm";
	}
	
	@RequestMapping("/adminForm/successForm")
	public String getSuccessForm() {
		
		return "/administrator/successForm";
	}
	
	@RequestMapping("/adminForm/unSuccessForm")
	public String getUnSuccessForm() {
		
		return "/administrator/unSuccessForm";
	}
}
