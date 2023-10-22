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
import com.projet.monuments.service.CelebriteService;
import com.projet.monuments.service.MonumentService;

@Controller
public class SearchTypeMController {
	@Autowired
	private MonumentService monServ;
	
	
	  @GetMapping(value = "/typeM")
	  public String findByTypeM(Model model, @RequestParam (value="typeM") String typeM){
				  model.addAttribute("typM", monServ.findByTypeM(typeM));
			  return "/typeM";}	
	  
}
