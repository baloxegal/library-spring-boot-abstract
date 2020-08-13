package com.example.demo.services;

import java.util.Optional;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.demo.db.UserRepositoryInterface;
import com.example.demo.domain.User;

@Service
public class UserService {
		
	public UserService() {
	}
	
	@Inject	
	private UserRepositoryInterface userRepository;
	
	@Inject
	private HttpSession session;
	
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
				
		User user = userRepository.findByName(email, password);
		
		return user;
	}
	
	public User loggedInUser() {
		
		return (User) session.getAttribute("user");		
	}
	
	public User login(String email, String password) {
		
		User user = loggedInUser();
		if(user != null)
			return user;
		
		user = userRepository.findByName(email, password);
		if(user != null)
			session.setAttribute("user", user);
		return user;		
	}

}