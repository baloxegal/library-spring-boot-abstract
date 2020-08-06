package com.example.demo.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.domain.Genre;
import com.example.demo.services.BookService;

@Controller
public class BookController {	
	@Inject
	private BookService bookService;
	
	@RequestMapping("books")
	public String getAllBooks(Model model) {
				
		model.addAttribute("books", bookService.getAllBooks());
		
		return "book/allBooks";
	}
	
	@GetMapping("modifyBooks")
	public String modifyBooks() {
		
		return "book/modifyBooks";
	}

	@GetMapping("createBook")
	public String createBook() {
		
		return "book/createBook";
	}
	
	@GetMapping("save")
	public String saveBook(@RequestParam String title, int year, boolean available, String cover, String name, String fullName) {
		bookService.getAllBooks().iterator().forEachRemaining(b -> {if((b.getTitle().equals(title)) && (b.getAuthor().getFullName().equals(fullName)))
																	{new AdminController().getUnSuccessForm(); return;}
																	else {bookService.save(new Book(title, year, true, cover, new Genre(name), new Author(fullName)));}});
		
		return "administrator/successForm";
	}
}