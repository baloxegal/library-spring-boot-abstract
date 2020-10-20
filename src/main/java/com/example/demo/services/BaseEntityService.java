package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.demo.db.AuthorEntityRepositoryInterface;
import com.example.demo.db.BookEntityRepositoryInterface;
import com.example.demo.db.GenreEntityRepositoryInterface;
import com.example.demo.db.UserEntityRepositoryInterface;
import com.example.demo.domain.BaseEntity;

@Service
public class BaseEntityService {

	public BaseEntityService() {
	}
		
	@Inject
	private BookEntityRepositoryInterface bookEntityRepository;
	
	@Inject
	private AuthorEntityRepositoryInterface authorEntityRepository;
	
	@Inject
	private GenreEntityRepositoryInterface genreEntityRepository;
	
	@Inject
	private UserEntityRepositoryInterface userEntityRepository;
		
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
		
		foundEntities.add(bookEntityRepository.findByName(searchEntity));
		foundEntities.add(authorEntityRepository.findByName(searchEntity));
		foundEntities.add(genreEntityRepository.findByName(searchEntity));
				
		return foundEntities;
		
	}
	
	public Optional<? extends BaseEntity> findByName(String entities, String name){
		
		if(entities.equals("books")) {
			return bookEntityRepository.findByName(name);
		}
		else if(entities.equals("authors")) {
			return authorEntityRepository.findByName(name);
		}
		else if(entities.equals("genres")) {
			return genreEntityRepository.findByName(name);
		}
		else if(entities.equals("users")) {
			return userEntityRepository.findByName(name);
		}

		return null;
	
	}
	
	public void save(String entities, BaseEntity baseEntity){
		
		if(entities.equals("books")) {
			bookEntityRepository.save(baseEntity);
		}
		else if(entities.equals("authors")) {
			authorEntityRepository.findByName(name);
		}
		else if(entities.equals("genres")) {
			genreEntityRepository.findByName(name);
		}
		else if(entities.equals("users")) {
			userEntityRepository.findByName(name);
		}
	
	}
	
}
