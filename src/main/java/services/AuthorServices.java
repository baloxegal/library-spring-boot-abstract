package services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import db.AuthorRepositoryInterface;
import domain.Author;

@Service
public class AuthorServices {
	
	public AuthorServices() {
	}
	
	@Inject
	private AuthorRepositoryInterface authorRepositoryInterface;
	
	public Iterable<Author> getAllAuthors(){
		
		return authorRepositoryInterface.findAll();
	}

}
