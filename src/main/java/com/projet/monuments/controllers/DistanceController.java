package com.projet.monuments.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projet.monuments.models.Monument;
import com.projet.monuments.service.DepartementService;
import com.projet.monuments.service.MonumentService;


@Controller
public class DistanceController {
	@Autowired
	private MonumentService monServ;
	
	@Autowired
	DepartementService DepServ;
	
	  @GetMapping(path = "/distant")
	  public String getMonumentProx(Model model, @RequestParam (value="nom") String nom){
		  for(Monument monu : monServ.findAll()) {
			  if(monu.getNom().equals(nom)) {
			  model.addAttribute("distancs", monServ.getMonumentProx(monu));
		  return "/distant";}
}
			  return "/index";
	
	  }
	  
	  @GetMapping(value="/nomDep")
	  public String findByNomDep(Model model, @RequestParam (value="dep")String nom) {
		  model.addAttribute("nomdep", DepServ.findByNomDep(nom));
		  return "/nomDep";
	  }
	  
	  @GetMapping(path="/distanceMon")
	  public String getDistance(Model model, @RequestParam (value="nom1") String nom1, @RequestParam (value="nom2")String nom2) {
					  model.addAttribute("distance", monServ.getDistance(nom1, nom2));
					  return "/distanceMon";
}
}
