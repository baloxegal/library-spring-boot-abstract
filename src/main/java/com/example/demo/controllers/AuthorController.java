package com.example.demo.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Author;
import com.example.demo.services.AuthorService;

@Controller
public class AuthorController {
	@Inject
	private AuthorService authorService;
	
	@GetMapping("/authors")
	public String findAll(Model model) {
		
		model.addAttribute("authors", authorService.findAll());
		
		return "/author/findAllAuthors";
	}
	
	@GetMapping("/adminForm/modifyAuthors")
	public String modifyAuthors() {
		
		return "/author/modifyAuthors";
	}

	@GetMapping("/adminForm/modifyAuthors/createAuthor")
	public String createAuthor(Model model) {
				
		return "/author/createAuthor";
	}
	
	@PostMapping("/adminForm/modifyAuthors/createAuthor")
	public String save(@RequestParam String fullName) {

		if(fullName.isBlank() || fullName.isEmpty() || fullName == null) {
			return "/administrator/unSuccessForm";
		}
		
		authorService.save(new Author(fullName));
		
		return "/administrator/successForm";
	}
	
}
