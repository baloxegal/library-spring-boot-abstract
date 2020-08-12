package com.example.demo.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Genre;
import com.example.demo.services.GenreService;

@Controller
public class GenreController {
	@Inject
	private GenreService genreService;
	
	@GetMapping("/genres")
	public String findAll(Model model) {
		
		model.addAttribute("genres", genreService.findAll());
		
		return "/genre/findAllGenres";
	}
	
	@GetMapping("/adminForm/modifyGenres")
	public String modifyBooks() {
		
		return "/genre/modifyGenres";
	}

	@GetMapping("/adminForm/modifyGenres/createGenre")
	public String createBook(Model model) {
				
		return "/genre/createGenre";
	}
	
	@PostMapping("/adminForm/modifyGenres/createGenre")
	public String save(@RequestParam String name) {

		if(name.isBlank() || name.isEmpty() || name == null) {
			return "/administrator/unSuccessForm";
		}
		
		genreService.save(new Genre(name));
		
		return "/administrator/successForm";
	}
}
