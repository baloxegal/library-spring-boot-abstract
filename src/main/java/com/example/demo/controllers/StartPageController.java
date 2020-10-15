package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartPageController {
	
	@GetMapping("")
	public String IndexStart() {
						
		return "/startPage/index";
	}
	
	@GetMapping("/index")
	public String IndexIndex() {
		
		return "/startPage/index";
	}
}