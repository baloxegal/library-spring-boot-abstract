package com.example.demo.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.services.BookService;

@Controller
public class BookController {	
	@Inject
	private BookService bookService;
	
	@RequestMapping("books")
	public String getAllBooks(Model model) {
				
		model.addAttribute("books", bookService.getAllBooks());
		
		return "book/index";
	}

}
