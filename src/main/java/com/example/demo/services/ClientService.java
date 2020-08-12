package com.example.demo.services;

import java.util.Optional;

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
	
	public Iterable<Client> findAll(){
		
		return clientRepository.findAll(); 
	}
	
	public void save(Client client){
		
		clientRepository.save(client);
	}
	
	public Optional<Client> findById(Long clientId){
		
		return clientRepository.findById(clientId);
	}

}
