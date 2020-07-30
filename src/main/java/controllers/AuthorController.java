package controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import services.AuthorServices;

@Controller
public class AuthorController {
	@Inject
	private AuthorServices authorServices;
	
	@RequestMapping("authors")
	public String getAllAuthors(Model model) {
		
		model.addAttribute("authors", authorServices.getAllAuthors());
		
		return "authors";
	}
	
}
