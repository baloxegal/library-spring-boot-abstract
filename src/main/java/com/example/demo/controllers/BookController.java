package com.example.demo.controllers;

import javax.inject.Inject;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.domain.Genre;
import com.example.demo.services.AuthorService;
import com.example.demo.services.BookService;
import com.example.demo.services.GenreService;

@Controller
public class BookController {	
	@Inject
	private BookService bookService;
	@Inject
	private AuthorService authorService;
	@Inject
	private GenreService genreService;
	
//	@RequestMapping("/books")
	@GetMapping("/books")
	public String findAll(Model model) {
				
		model.addAttribute("books", bookService.findAll());
		
		return "/book/findAllBooks";
	}
	
	@GetMapping("/adminForm/modifyBooks")
	public String modifyBooks() {
		
		return "/book/modifyBooks";
	}

	@GetMapping("/adminForm/modifyBooks/createBook")
	public String createBook(Model model) {
		
		List <Integer> years = new ArrayList<>();
		for(int i = 1900; i <= LocalDate.now().getYear(); i++) {
			years.add(i);
		}
		
		model.addAttribute("years", years);
		model.addAttribute("authors", authorService.findAll());
		model.addAttribute("genres", genreService.findAll());
		
		return "/book/createBook";
	}
	
	@PostMapping("/adminForm/modifyBooks/createBook")
	public String save(@RequestParam String title, Integer year, Boolean isAvailable, String cover, Long genre_id, Long author_id) {
		
		if(title.isBlank() || title.isEmpty() || title == null || year == null || cover.isBlank() || cover.isEmpty() || cover == null || genre_id == null || author_id == null) {
			return "/administrator/unSuccessForm";
		}
		
		Genre genre = genreService.findById(genre_id).get();
		Author author = authorService.findById(author_id).get();
				
		bookService.save(new Book(title, year, isAvailable, cover, genre, author));
				
		return "/administrator/successForm";
	}
}