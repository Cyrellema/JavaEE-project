package com.projet.monuments.controllers;

import java.io.Writer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;

@Controller
public class HomeController{

	@RequestMapping(path="/")
	public String index() {
        return "/index";
	
}
	
	@GetMapping(path="/home")
	public String adminHome(@RequestParam("login")String login) {
		if(login.equals("admin")) {
        return "/home_page";}
		else
			return "/index";
	
}

}
