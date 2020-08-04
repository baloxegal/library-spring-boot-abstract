package com.example.demo.services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.demo.db.GenreRepositoryInterface;
import com.example.demo.domain.Genre;

@Service
public class GenreService {
	
	public GenreService() {
	}
	
	@Inject
	private GenreRepositoryInterface genreRepository;
	
	public Iterable<Genre> getAllGenres(){
	
		return genreRepository.findAll();
	}

}
