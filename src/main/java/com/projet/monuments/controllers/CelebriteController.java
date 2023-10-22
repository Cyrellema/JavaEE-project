package com.projet.monuments.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.projet.monuments.models.Celebrite;
import com.projet.monuments.service.CelebriteService;

@Controller
public class CelebriteController {
	@Autowired
	  CelebriteService celebService;
	
	  @PostMapping(value = "/addCeleb")
	  public String createCelebrite(@ModelAttribute("celebrite") Celebrite celebrite, Model model) {
	     celebService.createCelebrite(celebrite);
	     model.addAttribute("celebrite", new Celebrite());
	     return "/celebrites";
	  }
	  
	  @PostMapping(value = "/modifCeleb")
	  public String
	     updateCelebrite(@ModelAttribute("celebrite") Celebrite celebrite, Model model) {
	     celebService.updateCelebrite(celebrite);
	     model.addAttribute("celebrite", celebrite);
	     return "/celebrites";
	  }
	  
	  @PostMapping(value = "/suprCeleb")
	  public String deleteCelebrite(Model model, @RequestParam(value="numCelebrite") String numCelebrite) {
	     celebService.deleteCelebrite(numCelebrite);
	     return "/celebrites";
	  }
	  
	  @GetMapping(path = "/celebrites")
	  public ModelAndView getCelebrites(){
			ModelAndView mav = new ModelAndView("celebrites");
			mav.addObject("celeb", celebService.findAll());
			return mav;
	  }

	

}
