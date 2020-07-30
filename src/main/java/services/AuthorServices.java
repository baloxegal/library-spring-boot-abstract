package services;

//import java.util.ArrayList;
//import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import db.AuthorInterface;
import domain.Author;

@Service
public class AuthorServices {
	
	public AuthorServices() {
	}
	
	@Inject
	private AuthorInterface authorInterface;
	
	public Iterable<Author> getAllAuthors(){
		
//		List <Author> authors = new ArrayList<>();
//		
//		authors.add(new Author("Николай Островский"));
//		authors.add(new Author("Антуан де Сент-Экзюпери"));
//		authors.add(new Author("Михаил Шолохов"));
//		authors.add(new Author("Лев Толстой"));
//		
//		return authors;
		
		return authorInterface.findAll();
	}

}
