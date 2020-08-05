package com.example.demo.db;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Genre;

@Repository
public interface GenreRepositoryInterface extends CrudRepository<Genre, Long>  {

//	@Override
//	default Iterable<Genre> findAll() {
//		
//		List<Genre> genres = new ArrayList<>();
//		
//		genres.add(new Genre("Революционное мясо"));
//		genres.add(new Genre("Для покурить"));
//		genres.add(new Genre("Революция Мексикана"));
//		genres.add(new Genre("Мясо по французки"));
//		
//		return genres;
//	}
	
}
