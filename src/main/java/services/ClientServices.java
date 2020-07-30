package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import domain.Client;

@Service
public class ClientServices {
	
	public ClientServices() {
	}
	
	public List<Client> getClients(){
		
		List<Client> clients = new ArrayList<>();
		
		clients.add(new Client("Гица Гаванос"));
		clients.add(new Client("Василе Конилэ"));
		clients.add(new Client("Петру Маранделу"));
		clients.add(new Client("Миричика Курунсус"));
		
		return clients;
	}

}
