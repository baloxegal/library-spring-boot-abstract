package com.example.demo.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Client;

@Repository
public interface ClientRepositoryInterface extends CrudRepository<Client, Long>  {

//		clients.add(new Client("Гица Гаванос"));
//		clients.add(new Client("Василе Конилэ"));
//		clients.add(new Client("Петру Маранделу"));
//		clients.add(new Client("Миричика Курунсус"));

}
