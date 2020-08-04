package com.example.demo.services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.demo.db.AuthorRepositoryInterface;
import com.example.demo.db.BookRepositoryInterface;
import com.example.demo.db.GenreRepositoryInterface;
import com.example.demo.domain.Book;

@Service
public class BookService {
	
	public BookService() {
	}
	
	@Inject
	private AuthorRepositoryInterface authorRepository;
	@Inject
	private GenreRepositoryInterface genreRepository;
	@Inject
	private BookRepositoryInterface bookRepository;
	
	public Iterable<Book> getAllBooks(){
		
		return bookRepository.findAll(authorRepository.findAll(), genreRepository.findAll());
	}

}
