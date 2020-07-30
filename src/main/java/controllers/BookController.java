package controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Book;
import services.BookServices;

@Controller
public class BookController {	
	@Inject
	private BookServices bookServices;
	
	@RequestMapping("books")
	public String getAllBooks(Model model) {
		
		List <Book> books = bookServices.getAllBooks();
		
		model.addAttribute("books", books);
		
		return "books";
	}

}
