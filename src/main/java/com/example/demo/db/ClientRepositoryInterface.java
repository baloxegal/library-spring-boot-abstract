package com.example.demo.db;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Client;

@Repository
public interface ClientRepositoryInterface extends CrudRepository<Client, Long>  {

//	@Override
//	default Iterable<Client> findAll() {
//		
//		List<Client> clients = new ArrayList<>();
//		
//		clients.add(new Client("Гица Гаванос"));
//		clients.add(new Client("Василе Конилэ"));
//		clients.add(new Client("Петру Маранделу"));
//		clients.add(new Client("Миричика Курунсус"));
//		
//		return clients;
//	}

}
