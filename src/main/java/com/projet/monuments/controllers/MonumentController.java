package com.projet.monuments.controllers;

import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.*;

import com.projet.monuments.models.Monument;
import com.projet.monuments.service.MonumentService;

@Controller

public class MonumentController {

@Autowired
MonumentService monumentService;

List<Monument> monuments = new ArrayList<>();
   
  @PostMapping(path = "/addMon")
     public String createMonument(@ModelAttribute("monument") Monument monument, BindingResult bindingResult, Model model) {
	  if (bindingResult.hasErrors()) {
          System.out.println("problème "+bindingResult);
          } 
	  model.addAttribute("monument", new Monument()); 
    	 monumentService.createMonument(monument);
    	 return "/monuments";
  }
  
  @PostMapping(path ="/modifMon")
  public String updateMonument(@ModelAttribute("monument") Monument monument, BindingResult bindingResult, Model model) {
	  model.addAttribute("monument", monument);
     monumentService.updateMonument(monument);
     return "/monuments";
  }
  
  @PostMapping(path = "/suprMon")
  public String deleteMonument(Model model, @RequestParam(value="geohash") String geohash) {
     monumentService.deleteMonument(geohash);
     return "/monuments";
}
  
  @GetMapping(path = "/monuments")
  public ModelAndView getMonuments(){
		ModelAndView mav = new ModelAndView("monuments");
		mav.addObject("monumen", monumentService.findAll());
		return mav;
  }

 
}