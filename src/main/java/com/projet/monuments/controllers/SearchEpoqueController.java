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

import com.projet.monuments.models.Celebrite;
import com.projet.monuments.models.Monument;
import com.projet.monuments.service.CelebriteService;

@Controller
public class SearchEpoqueController {
	
	@Autowired
	CelebriteService celebServ;
	

	  @GetMapping(path = "/epoq")
	  public String getByEpoque(Model model, @RequestParam (value="epoque") String epoque){
		  for(Celebrite celeb : celebServ.findAll()) {
			  if(celeb.getEpoque().equals(epoque)) {
			  model.addAttribute("epoqu", celebServ.getByEpoque(epoque));
		  return "/epoq";}
}
			  return "/index";
	
	  }
	  

}
