package com.example.demo.services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.demo.db.AuthorRepositoryInterface;
import com.example.demo.domain.Author;

@Service
public class AuthorService {
	
	public AuthorService() {
	}
	
	@Inject
	private AuthorRepositoryInterface authorRepository;
	
	public Iterable<Author> getAllAuthors(){
		
		return authorRepository.findAll();
	}

}
