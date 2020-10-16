package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import org.springframework.stereotype.Service;

import com.example.demo.db.BaseEntityRepositoryInterface;
import com.example.demo.domain.Author;
import com.example.demo.domain.BaseEntity;
import com.example.demo.domain.Book;
import com.example.demo.domain.Genre;
import com.example.demo.domain.User;

@Service
public class BaseEntityService {

	public BaseEntityService() {
	}
		
	@Inject
	private BaseEntityRepositoryInterface<Book> bookEntityRepository;
	
	@Inject
	private BaseEntityRepositoryInterface<Author> authorEntityRepository;
	
	@Inject
	private BaseEntityRepositoryInterface<Genre> genreEntityRepository;
	
	@Inject
	private BaseEntityRepositoryInterface<User> userEntityRepository;
		
	public Iterable<? extends BaseEntity> findAll(String entities){
		
		if(entities.equals("books")) {
			return bookEntityRepository.findAll();
		}
		else if(entities.equals("authors")) {
			return authorEntityRepository.findAll();
		}
		else if(entities.equals("genres")) {
			return genreEntityRepository.findAll();
		}
		else if(entities.equals("users")) {
			return userEntityRepository.findAll();
		}
				
		return null;
	}
		
	public Optional<? extends BaseEntity> findById(String entities, Long baseEntityId){
		
		if(entities.equals("books")) {
			return bookEntityRepository.findById(baseEntityId);
		}
		else if(entities.equals("authors")) {
			return authorEntityRepository.findById(baseEntityId);
		}
		else if(entities.equals("genres")) {
			return genreEntityRepository.findById(baseEntityId);
		}
		else if(entities.equals("users")) {
			return userEntityRepository.findById(baseEntityId);
		}
				
		return null;
	
	}
	
	public List<Optional<? extends BaseEntity>> search(String searchEntity){
				
		List<Optional<? extends BaseEntity>> foundEntities = new ArrayList<>();
		
		foundEntities.add(bookEntityRepository.findById(Long.parseLong(searchEntity)));
		foundEntities.add(authorEntityRepository.findById(Long.parseLong(searchEntity)));
		foundEntities.add(genreEntityRepository.findById(Long.parseLong(searchEntity)));
		
		foundEntities.add(bookEntityRepository.findByName("Book", "name"));
		foundEntities.add(authorEntityRepository.findByName("Author", "name"));
		foundEntities.add(genreEntityRepository.findByName("Genre", "name"));
				
		return foundEntities;
	}
	
	public Optional<? extends BaseEntity> findByName(String entities, String name){
		
		String entity = entities.substring(0, 1).toUpperCase() + entities.substring(1, entities.length() - 1);
		
		if(entities.equals("books")) {
			return bookEntityRepository.findByName(entity, name);
		}
		else if(entities.equals("authors")) {
			return authorEntityRepository.findByName(entity, name);
		}
		else if(entities.equals("genres")) {
			return genreEntityRepository.findByName(entity, name);
		}
		else if(entities.equals("users")) {
			return userEntityRepository.findByName(entity, name);
		}
				
		return null;
	
	}
	
}
