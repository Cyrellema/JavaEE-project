package com.projet.monuments.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projet.monuments.models.Lieu;
import com.projet.monuments.models.Monument;
import com.projet.monuments.service.LieuService;
import com.projet.monuments.service.MonumentService;

@Controller
public class SearchLieuController {
	
	@Autowired
	MonumentService monServ;
	
	@Autowired 
	LieuService lieuServ;
	
	  @GetMapping(path = "/comm")
	  public String findByCodeInsee(Model model, @RequestParam (value="codeInsee") Lieu codeInsee){
			  model.addAttribute("coms", monServ.findByCodeInsee(codeInsee));
		  return "/comm";}	
	  
	  @GetMapping(value="/nomCom")
	  public String findByNomCom(Model model, @RequestParam(value="nomCom") String nomCom) {
		  model.addAttribute("nomcom", lieuServ.findByNomCom(nomCom));
		  return "/nomCom";
	  }
	  
	  @GetMapping(value="/byDep")
	  public String findByDep(Model model, @RequestParam(value="dep") String dep) {
		  model.addAttribute("Dep", lieuServ.findByDep(dep));
		  return "/byDep";
	  }

	  
}
