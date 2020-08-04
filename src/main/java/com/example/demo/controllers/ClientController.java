package com.example.demo.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.services.ClientService;

@Controller
public class ClientController {
	@Inject
	private ClientService clientService;
	
	@RequestMapping("clients")
	public String getAllClients(Model model) {
			
		model.addAttribute("clients", clientService.getAllClients());
		
		return "client/index";
	}

}
