package com.biblio.bibliotheque.controller;

import com.biblio.bibliotheque.entity.Auteur;

import com.biblio.bibliotheque.service.AuteurService;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class AuteurController {
    @Autowired
    AuteurService auteurService;

    @RequestMapping("/saveAuteur")
   
	public String saveAuteur(Auteur auteur,
			 BindingResult bindingResult)
			{
			if (bindingResult.hasErrors()) return "formAuteur";

			auteurService.saveAuteur(auteur);
			return "fromAuteur";
			}

 
}
