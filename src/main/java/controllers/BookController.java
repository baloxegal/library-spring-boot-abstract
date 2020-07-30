package controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import services.BookServices;

@Controller
public class BookController {	
	@Inject
	private BookServices bookServices;
	
	@RequestMapping("books")
	public String getAllBooks(Model model) {
				
		model.addAttribute("books", bookServices.getAllBooks());
		
		return "book/index";
	}

}
