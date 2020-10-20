package com.example.demo.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.BaseEntity;
import com.example.demo.services.BaseEntityService;

@RequestMapping("/admin/{entity}")
@Controller
public class AdminController {
	@Inject
	private BaseEntityService baseEntityService;
	
	@GetMapping("/create")
	public String create(@PathVariable("entity") String entity) {
		entity = entity.substring(0, 1).toUpperCase() + entity.substring(1, entity.length() - 1);
		return "/create " + entity;
	}
	
	@PostMapping("/create")
	public String save(@PathVariable("entity") String entity, @RequestParam String name) {

		if(name.isBlank() || name.isEmpty() || name == null) {
			return "/unSuccessForm";
		}
		
		baseEntityService.save(entity, new BaseEntity(name));
		
		return "/admin";
	}
	
	@GetMapping("/adminForm/modifyAuthors")
	public String modifyAuthors() {
		
		return "/author/modifyAuthors";
	}

	@GetMapping("/adminForm/modifyAuthors/createAuthor")
	public String createAuthor(Model model) {
				
		return "/author/createAuthor";
	}
		
}
