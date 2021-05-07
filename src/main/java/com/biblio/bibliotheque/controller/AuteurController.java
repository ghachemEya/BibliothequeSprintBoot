package com.biblio.bibliotheque.controller;

import java.util.List;

import com.biblio.bibliotheque.Exceptions.AuteurNotFoundException;
import com.biblio.bibliotheque.entity.Auteur;
import com.biblio.bibliotheque.repository.AuteurRepo;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AuteurController {

    private  AuteurRepo repository;

	AuteurController(AuteurRepo respo){
		this.repository = respo;
	}


	//Aggregare root 
	@GetMapping("/auteurs")
  	List<Auteur> all() {
    return repository.findAll();
    }

	@PostMapping("/auteurs")
  	Auteur newauteur(@RequestBody Auteur newAuteur) {
    return repository.save(newAuteur);
  	}

   // Single item
  
   @GetMapping("/auteurs/{id}")
   
   Auteur one(@PathVariable Long id) {
	 
	return repository.findById(id)
	.orElseThrow(() -> new AuteurNotFoundException(id));
   }
 
   @PutMapping("/auteurs/{id}")
   Auteur replaceauteur(@RequestBody Auteur newauteur, @PathVariable Long id) {
	 
	 return repository.findById(id)
	   .map(auteur -> {
		 auteur.setName(newauteur.getName());
		 auteur.setLastName(newauteur.getLastName());
		 auteur.setNationalite(newauteur.getNationalite());
		 return repository.save(auteur);
	   })
	   .orElseGet(() -> {
		 newauteur.setId(id);
		 return repository.save(newauteur);
	   });
   }
 

   @DeleteMapping("/auteurs/{id}")
  	void deleteAuteur(@PathVariable Long id) {
    repository.deleteById(id);
  }

}
