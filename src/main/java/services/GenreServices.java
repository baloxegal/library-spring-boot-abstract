package services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import db.GenreRepositoryInterface;
import domain.Genre;

@Service
public class GenreServices {
	
	public GenreServices() {
	}
	
	@Inject
	private GenreRepositoryInterface genreRepositoryInterface;
	
	public Iterable<Genre> getAllGenres(){
	
		return genreRepositoryInterface.findAll();
	}

}
