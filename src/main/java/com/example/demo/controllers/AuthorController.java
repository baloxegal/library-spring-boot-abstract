package com.example.demo.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.services.AuthorService;

@Controller
public class AuthorController {
	@Inject
	private AuthorService authorService;
	
	@RequestMapping("authors")
	public String getAllAuthors(Model model) {
		
		model.addAttribute("authors", authorService.getAllAuthors());
		
		return "author/index";
	}
	
}
