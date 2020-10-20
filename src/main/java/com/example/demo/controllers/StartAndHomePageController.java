package com.example.demo.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.services.BaseEntityService;

@Controller
public class StartAndHomePageController {
	
	@Inject
	private BaseEntityService baseEntityService;
		
	@GetMapping("")
	public String getStartPage(Model model) {
				
		model.addAttribute("books", baseEntityService.findAll("books"));
		model.addAttribute("url", "");
		
		return "/index";
	}
	
	@GetMapping("/home")
	public String getHomePage(Model model) {
				
		model.addAttribute("books", baseEntityService.findAll("books"));
		model.addAttribute("url", "home");
		
		return "/index";
	}
	
	@PostMapping("/home")
	public String searchFromHomePage(@RequestParam String searchEntity, Model model) {
				
		model.addAttribute("baseEntities", baseEntityService.search("searchEntity"));
		
		return "/search";
	}
	
}