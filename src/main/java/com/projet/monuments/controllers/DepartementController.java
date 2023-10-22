package com.projet.monuments.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.projet.monuments.models.Departement;
import com.projet.monuments.models.Monument;
import com.projet.monuments.service.DepartementService;

@Controller
public class DepartementController {
	@Autowired
	DepartementService depService;
	
	@PostMapping(value="/addDep")
	public String createDepartement(@ModelAttribute("departement") Departement departement, Model model) {
		 System.out.println(departement.getDep());
		  model.addAttribute("departement", new Departement()); 
	     depService.createDepartement(departement);
	     return "/departements";
	}
	
	@PostMapping(value = "/modifDep")
	  public String
	     updateDepartement(@ModelAttribute("departement") Departement departement,Model model) {
		  model.addAttribute("departement", departement); 
		depService.updateDepartement(departement);
	    return "/departements";
	}
	  
	@PostMapping(value = "/suprDep")
	  public String deleteDepartement(Model model, @RequestParam(value="dep") String dep) {
	     depService.deleteDepartement(dep);
	     return "/departements";
	}
	  
	  @GetMapping(value = "/departements")
	  public ModelAndView getDepartements(){
			ModelAndView mav = new ModelAndView("departements");
			mav.addObject("depart", depService.getDepartements());
			return mav;
	  }

	
}
