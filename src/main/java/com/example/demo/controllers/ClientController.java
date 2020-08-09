package com.example.demo.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Client;
import com.example.demo.services.ClientService;

@Controller
public class ClientController {
	@Inject
	private ClientService clientService;
	
	@RequestMapping("/clients")
	public String findAll(Model model) {
			
		model.addAttribute("clients", clientService.findAll());
		
		return "/client/findAllClients";
	}
	
	@RequestMapping("/adminForm/modifyClients")
	public String modifyBooks() {
		
		return "/client/modifyClients";
	}

	@RequestMapping("/adminForm/modifyClients/createClient")
	public String createBook(Model model) {
				
		return "/client/createClient";
	}
	
	@RequestMapping("/adminForm/modifyClients/createClient/saveClient")
	public String save(@RequestParam String fullName) {

		clientService.save(new Client(fullName));
		
		return "/administrator/successForm";
	}

}
