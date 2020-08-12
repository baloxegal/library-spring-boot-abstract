package com.example.demo.services;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.demo.db.BookRepositoryInterface;
import com.example.demo.domain.Book;

@Service
public class BookService {
	
	public BookService() {
	}
	
	@Inject
	private BookRepositoryInterface bookRepository;
	
	public Iterable<Book> findAll(){
		
		return bookRepository.findAll();
	}
	
	public void save(Book book){
		
		bookRepository.save(book);
	}
	
	public Optional<Book> findById(Long bookId){
		
		return bookRepository.findById(bookId);
	}
	
}
