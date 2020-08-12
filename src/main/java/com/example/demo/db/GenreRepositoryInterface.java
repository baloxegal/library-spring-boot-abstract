package com.example.demo.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Genre;

@Repository
public interface GenreRepositoryInterface extends CrudRepository<Genre, Long>  {

//		genres.add(new Genre("Революционное мясо"));
//		genres.add(new Genre("Для покурить"));
//		genres.add(new Genre("Революция Мексикана"));
//		genres.add(new Genre("Мясо по французки"));

}
