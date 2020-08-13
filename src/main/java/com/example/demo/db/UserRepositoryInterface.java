package com.example.demo.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.User;

@Repository
public interface UserRepositoryInterface extends CrudRepository<User, Long>  {

//		clients.add(new User("Гица Гаванос"));
//		clients.add(new User("Василе Конилэ"));
//		clients.add(new User("Петру Маранделу"));
//		clients.add(new User("Миричика Курунсус"));

	@Query("select u from users_ u where u.login = ?1 and u.password = ?2")
	public User findByName(String email, String password);
	
}
