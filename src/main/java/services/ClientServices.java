package services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import db.ClientRepositoryInterface;
import domain.Client;

@Service
public class ClientServices {
		
	public ClientServices() {
	}
	
	@Inject	
	private ClientRepositoryInterface clientRepositoryInterface;
	
	public Iterable<Client> getAllClients(){
		
		return clientRepositoryInterface.findAll(); 
	}

}
