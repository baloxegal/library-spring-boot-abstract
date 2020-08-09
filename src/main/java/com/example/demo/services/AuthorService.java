package com.example.demo.services;

import java.util.Optional;

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
	
	public Iterable<Author> findAll(){
		
		return authorRepository.findAll();
	}
	
	public void save(Author author){
		
		authorRepository.save(author);
	}
	
	public Optional<Author> findById(Long authorId){
		
		return authorRepository.findById(authorId);
	}

}
