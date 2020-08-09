package com.example.demo.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Genre;
import com.example.demo.services.GenreService;

@Controller
public class GenreController {
	@Inject
	private GenreService genreService;
	
	@RequestMapping("/genres")
	public String findAll(Model model) {
		
		model.addAttribute("genres", genreService.findAll());
		
		return "/genre/findAllGenres";
	}
	
	@RequestMapping("/adminForm/modifyGenres")
	public String modifyBooks() {
		
		return "/genre/modifyGenres";
	}

	@RequestMapping("/adminForm/modifyGenres/createGenre")
	public String createBook(Model model) {
				
		return "/genre/createGenre";
	}
	
	@RequestMapping("/adminForm/modifyGenres/createGenre/saveGenre")
	public String save(@RequestParam String name) {

		genreService.save(new Genre(name));
		
		return "/administrator/successForm";
	}
}
