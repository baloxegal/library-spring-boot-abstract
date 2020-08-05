package com.example.demo.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.services.GenreService;

@Controller
public class GenreController {
	@Inject
	private GenreService genreService;
	
	@RequestMapping("genres")
	public String getGenre(Model model) {
		
		model.addAttribute("genres", genreService.getAllGenres());
		
		return "genre/allGenres";
	}
}
