package com.biblio.bibliotheque.controller;

import java.util.List;

import com.biblio.bibliotheque.Exceptions.CategorieNotFoundException;
import com.biblio.bibliotheque.entity.Categorie;
import com.biblio.bibliotheque.repository.CategorieRepo;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CategorieController {
    
    private  CategorieRepo repository;

	CategorieController(CategorieRepo respo){
		this.repository = respo;
	}


    @GetMapping("/categories")
  	List<Categorie> all() {
    return repository.findAll();
    }

	@PostMapping("/categories")
    Categorie newauteur(@RequestBody Categorie newCategorie) {
    return repository.save(newCategorie);
  	}

    @GetMapping("/categories/{id}")
   
      Categorie one(@PathVariable Long  id) {
        
       return repository.findById(id)
       .orElseThrow(() -> new CategorieNotFoundException(id));
      }
    
    @PutMapping("/categories/{id}")
    Categorie replaceauteur(@RequestBody Categorie newCategorie, @PathVariable Long id) {
        
        return repository.findById(id)
          .map(categorie -> {
            categorie.setLibelle(newCategorie.getLibelle());
            return repository.save(categorie);
          })
          .orElseGet(() -> {
            newCategorie.setId(id);
            return repository.save(newCategorie);
          });
      }
    
   
    @DeleteMapping("/categories/{id}")
         void deleteCategorie(@PathVariable Long id) {
       repository.deleteById(id);
     }
}
