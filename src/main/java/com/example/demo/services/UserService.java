package com.example.demo.services;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.demo.db.UserRepositoryInterface;
import com.example.demo.domain.User;

@Service
public class UserService {
		
	public UserService() {
	}
	
	@Inject	
	private UserRepositoryInterface userRepository;
	
	public Iterable<User> findAll(){
		
		return userRepository.findAll(); 
	}
	
	public void save(User user){
		
		userRepository.save(user);
	}
	
	public Optional<User> findById(Long userId){
		
		return userRepository.findById(userId);
	}
	
	public User findByName(String email, String password) {
				
		userRepository.findByName(email, password);
		
		return null;
	}

}
