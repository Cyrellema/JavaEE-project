package com.projet.monuments.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.projet.monuments.models.Lieu;
import com.projet.monuments.models.Monument;
import com.projet.monuments.service.LieuService;

@Controller
public class LieuController {
	@Autowired
	private LieuService lieuService;
	
@PostMapping(value="/addCom")
	  public String createLieu(@ModelAttribute("lieu") Lieu lieu, BindingResult bindingResult, Model model) {
		  if (bindingResult.hasErrors()) {
	          System.out.println("problème "+bindingResult);
	          } 
		  model.addAttribute("lieu", new Lieu()); 
			lieuService.createLieu(lieu);
	    	 return "/lieux";
}

@PostMapping(path="/modifCom")
	  public String updateMonument(@ModelAttribute("lieu") Lieu lieu, BindingResult bindingResult, Model model) {
		  model.addAttribute("lieu", lieu);
			lieuService.updateLieu(lieu);
	     return "/lieux";
}

@PostMapping(path="/suprCom")
public String deleteLieu(Model model, @RequestParam(value="codeInsee") String codeInsee){
	lieuService.deleteLieu(codeInsee);
	return "/lieux";
}

@GetMapping(path="/lieux")
	  public ModelAndView getLieux(){
			ModelAndView mav = new ModelAndView("lieux");
			mav.addObject("lieus", lieuService.getLieux());
			return mav;
	  }
}
