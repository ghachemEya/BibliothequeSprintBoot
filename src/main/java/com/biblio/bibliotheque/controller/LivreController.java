package com.biblio.bibliotheque.controller;

import java.util.List;

import com.biblio.bibliotheque.entity.Livre;
import com.biblio.bibliotheque.repository.LivreRepo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivreController {
    private  LivreRepo repository;

	LivreController(LivreRepo respo){
		this.repository = respo;
	}


    @GetMapping("/livres")
  	List<Livre> all() {
    return repository.findAll();
    }
    
}
