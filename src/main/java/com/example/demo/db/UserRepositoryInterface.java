package com.example.demo.db;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.User;

@Repository
public interface UserRepositoryInterface extends CrudRepository<User, Long>  {

//		clients.add(new User("Гица Гаванос"));
//		clients.add(new User("Василе Конилэ"));
//		clients.add(new User("Петру Маранделу"));
//		clients.add(new User("Миричика Курунсус"));
	
	@Query("select u from User u where u.email = ?1 and u.password = ?2")
	public User findByEmailAndPass(String email, String password);
	
	@Query("select u from User u where u.email = ?1")
	public User findByEmail(String email);
	
	@Query("select u from User u where u.role = ?1")
	public User findByRole(String role);
	
	@Query("select u from User u where u.role = ?1")
	public Iterable<User> findAllByRole(String role);
	
	@Transactional
	@Modifying
	@Query("update User u set u.role = ?1 where u.email = ?2")
	public void setRoleDataBase(String role, String email);
	
	@Transactional
	@Modifying
	@Query("update User u set u.fullName = ?1 where u.email = ?2")
	public void setFullNameDataBase(String fullName, String email);
		
}
