package com.example.demo.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Author;

@Repository
public interface AuthorRepositoryInterface extends CrudRepository<Author, Long> {
    
//		authors.add(new Author("Николай Островский"));
//		authors.add(new Author("Антуан де Сент-Экзюпери"));
//		authors.add(new Author("Михаил Шолохов"));
//		authors.add(new Author("Лев Толстой"));
	
}
