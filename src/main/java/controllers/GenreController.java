package controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import services.GenreServices;

@Controller
public class GenreController {
	@Inject
	private GenreServices genreServices;
	
	@RequestMapping("genres")
	public String getGenre(Model model) {
		
		model.addAttribute("genres", genreServices.getAllGenres());
		
		return "genre/index";
	}
}
