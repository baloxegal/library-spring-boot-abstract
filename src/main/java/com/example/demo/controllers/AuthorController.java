package com.example.demo.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Author;
import com.example.demo.services.AuthorService;

@Controller
public class AuthorController {
	@Inject
	private AuthorService authorService;
	
	@RequestMapping("/authors")
	public String findAll(Model model) {
		
		model.addAttribute("authors", authorService.findAll());
		
		return "/author/findAllAuthors";
	}
	
	@RequestMapping("/adminForm/modifyAuthors")
	public String modifyBooks() {
		
		return "/author/modifyAuthors";
	}

	@RequestMapping("/adminForm/modifyAuthors/createAuthor")
	public String createBook(Model model) {
				
		return "/author/createAuthor";
	}
	
	@RequestMapping("/adminForm/modifyAuthors/createAuthor/saveAuthor")
	public String save(@RequestParam String fullName) {

		authorService.save(new Author(fullName));
		
		return "/administrator/successForm";
	}
	
}
