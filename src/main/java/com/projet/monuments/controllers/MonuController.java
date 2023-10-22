package com.projet.monuments.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projet.monuments.service.MonumentService;

@Controller
public class MonuController {
	
	@Autowired
	MonumentService monumentService; 
	
	  @GetMapping(path = "/monu")
	  public ModelAndView getMonuments(){
			ModelAndView mav = new ModelAndView("monu");
			mav.addObject("monumen", monumentService.findAll());
			return mav;
	  }
}
