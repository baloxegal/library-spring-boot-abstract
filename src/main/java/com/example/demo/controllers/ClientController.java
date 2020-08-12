package com.example.demo.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Client;
import com.example.demo.services.ClientService;

@Controller
public class ClientController {
	@Inject
	private ClientService clientService;
	
	@GetMapping("/clients")
	public String findAll(Model model) {
			
		model.addAttribute("clients", clientService.findAll());
		
		return "/client/findAllClients";
	}
	
	@GetMapping("/adminForm/modifyClients")
	public String modifyBooks() {
		
		return "/client/modifyClients";
	}

	@GetMapping("/adminForm/modifyClients/createClient")
	public String createBook(Model model) {
				
		return "/client/createClient";
	}
	
	@PostMapping("/adminForm/modifyClients/createClient")
	public String save(@RequestParam String fullName) {

		if(fullName.isBlank() || fullName.isEmpty() || fullName == null) {
			return "/administrator/unSuccessForm";
		}
		
		clientService.save(new Client(fullName));
		
		return "/administrator/successForm";
	}

}
