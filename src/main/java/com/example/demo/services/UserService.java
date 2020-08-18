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
	
	public User findByRole(String role) {
		
		return userRepository.findByRole(role);
	}
	
	public Iterable<User> findAllByRole(String role) {
		
		return userRepository.findAllByRole(role);
	}
	
	public void setRoleDataBase(String role, String email) {
		
		userRepository.setRoleDataBase(role, email);
	}
	
	public User findByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}
	
	public User findByEmailAndPass(String email, String password) {
				
		return userRepository.findByEmailAndPass(email, password);
	}
	
	public void setFullNameDataBase(String fullName, String email) {
		
		userRepository.setFullNameDataBase(fullName, email);
	}
	
	public User signedInUser(String email) {
		
		return (User) session.getAttribute(email);		
	}
	
	public User signIn(String email, String password) {
		
		User user = signedInUser(email);
		if(user != null)
			return user;
		
		user = userRepository.findByEmailAndPass(email, password);
		if(user != null)
			session.setAttribute(email, user);
		return user;		
	}
	
	public void signOut() {
		
		User user = (User) session.getAttribute("user");
		if(user != null)
			session.removeAttribute("user");
		
	}

}
