package com.example.demo.db;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Author;

@Repository
public interface AuthorRepositoryInterface extends CrudRepository<Author, Long> {
    
//	@Override
//	default Iterable<Author> findAll() {
//		
//		List<Author> authors = new ArrayList<>();
//		
//		authors.add(new Author("Николай Островский"));
//		authors.add(new Author("Антуан де Сент-Экзюпери"));
//		authors.add(new Author("Михаил Шолохов"));
//		authors.add(new Author("Лев Толстой"));
//		
//		return authors;
//	}
	
}
