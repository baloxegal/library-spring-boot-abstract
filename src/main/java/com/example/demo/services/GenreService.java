package com.example.demo.services;

import java.util.Optional;

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
	
	public Iterable<Genre> findAll(){
	
		return genreRepository.findAll();
	}
	
	public void save(Genre genre){
		
		genreRepository.save(genre);
	}
	
	public Optional<Genre> findById(Long genreId){
		
		return genreRepository.findById(genreId);
	}

}
