package controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Client;
import services.ClientServices;

@Controller
public class ClientController {
	@Inject
	private ClientServices clientServices;
	
	@RequestMapping("clients")
	public String getClients(Model model) {
		
		List<Client> clients = clientServices.getClients();
		
		model.addAttribute("clients", clients);
		
		return "clients";
	}

}
