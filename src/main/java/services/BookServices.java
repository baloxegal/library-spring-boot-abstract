package services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import db.AuthorRepositoryInterface;
import db.BookRepositoryInterface;
import db.GenreRepositoryInterface;
import domain.Book;

@Service
public class BookServices {
	
	public BookServices() {
	}
	
	@Inject
	private AuthorRepositoryInterface authorRepositoryInterface;
	@Inject
	private GenreRepositoryInterface genreRepositoryInterface;
	@Inject
	private BookRepositoryInterface bookRepositoryInterface;
	
	public Iterable<Book> getAllBooks(){
		
		return bookRepositoryInterface.findAll(authorRepositoryInterface.findAll(), genreRepositoryInterface.findAll());
	}

}
