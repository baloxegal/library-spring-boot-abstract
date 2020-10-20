package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.db.BookEntityRepositoryInterface;
import com.example.demo.domain.BaseEntity;
import com.example.demo.services.BaseEntityService;

@Controller
@RequestMapping("/view/{entities}")
public class BaseEntityController {
	
	@Inject
	private BaseEntityService baseEntityService;
	
	@GetMapping("/all")
	@ResponseBody
	public String findAll(@PathVariable("entities") String entities, Model model) {
		
		List<? extends BaseEntity> be = new ArrayList<>();
		
		model.addAttribute(entities, be);
		model.addAttribute("fields", be.get(0).getClass().getFields());
				
		return "/index";
		
	}
	
	@PostMapping("/byId")
	@ResponseBody
	public String findById(@PathVariable("entities") String entities, @RequestParam Long baseEntityId) {
		
		baseEntityService.findById(entities, baseEntityId);
		
		return "/index";
		
	}
		
}
