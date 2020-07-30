package controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import services.ClientServices;

@Controller
public class ClientController {
	@Inject
	private ClientServices clientServices;
	
	@RequestMapping("clients")
	public String getAllClients(Model model) {
			
		model.addAttribute("clients", clientServices.getAllClients());
		
		return "client/index";
	}

}
