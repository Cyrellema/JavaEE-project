package com.projet.monuments.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projet.monuments.models.Lieu;
import com.projet.monuments.service.CelebriteService;

@Controller
public class SearchCelebrite {
	
	@Autowired
	CelebriteService celebServ;
	
	  @GetMapping(path = "/natio")
	  public String findByNationalite(Model model, @RequestParam (value="nationalite") String nationalite){
			  model.addAttribute("nationalit", celebServ.findByNationalite(nationalite));
		  return "/nation";}	

	  @GetMapping(path = "/monuCeleb")
	  public String getByCelebrite(Model model, @RequestParam (value="nom") String nom) {
		  model.addAttribute("monuCeleb", celebServ.getByCelebrite(nom));
		  return "/monuCeleb";
	  }
	  
}
