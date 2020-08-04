package com.example.demo.services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.demo.db.ClientRepositoryInterface;
import com.example.demo.domain.Client;

@Service
public class ClientService {
		
	public ClientService() {
	}
	
	@Inject	
	private ClientRepositoryInterface clientRepository;
	
	public Iterable<Client> getAllClients(){
		
		return clientRepository.findAll(); 
	}

}