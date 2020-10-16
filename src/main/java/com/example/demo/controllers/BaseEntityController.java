package com.example.demo.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.services.BaseEntityService;

@Controller
@RequestMapping("/view/{entities}")
public class BaseEntityController {
	
	@Inject
	private BaseEntityService baseEntityService;
	
	@GetMapping("/all")
	@ResponseBody
	public String findAll(@PathVariable("entities") String entities, Model model) {
		
		
		model.addAttribute(entities, baseEntityService.findAll(entities));
		
//		return "/entities/view_all";
		return "This is BaseEntity Controller for view all entities of " + entities + "!!!";
	}
	
	@PostMapping("/byId")
	@ResponseBody
	public String findById(@PathVariable("entities") String entities, @RequestParam Long baseEntityId) {
		
		baseEntityService.findById(entities, baseEntityId);
		
//		return "/{entities}/view_by_id";
		return "This is BaseEntity Controller for view entity of " + entities + " by id " + baseEntityId + " !!!";
	}
		
}
