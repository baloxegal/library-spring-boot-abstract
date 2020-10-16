package com.example.demo.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.services.BaseEntityService;

@Controller
public class HomePageController {
	
	@Inject
	private BaseEntityService baseEntityService;
		
	@GetMapping("/home")
	public String getHomePage(Model model) {
				
		model.addAttribute("books", baseEntityService.findAll("books"));
		
		return "/index";
	}
	
	@PostMapping("/home")
	public String searchFromHomePage(@RequestParam String searchEntity, Model model) {
				
		model.addAttribute("entities", baseEntityService.search("searchEntity"));
		
		return "/search";
	}
	
}