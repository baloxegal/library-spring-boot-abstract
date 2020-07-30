package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import domain.Genre;

@Service
public class GenreServices {
	
	public GenreServices() {
	}
	
	public List<Genre> getAllGenres(){
		
		List<Genre> genres = new ArrayList<>();
				
		genres.add(new Genre("Революционное мясо"));
		genres.add(new Genre("Для покурить"));
		genres.add(new Genre("Революция Мексикана"));
		genres.add(new Genre("Мясо по французки"));
		
		return genres;
	}

}
