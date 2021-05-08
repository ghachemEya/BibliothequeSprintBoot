package com.biblio.bibliotheque.controller;

import java.util.List;

import com.biblio.bibliotheque.Exceptions.LivreNotFoundException;
import com.biblio.bibliotheque.entity.Livre;
import com.biblio.bibliotheque.repository.LivreRepo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivreController {
  private LivreRepo repository;

  LivreController(LivreRepo respo) {
    this.repository = respo;
  }

  @GetMapping("/livres")
  List<Livre> all() {
    return repository.findAll();
  }

  @PostMapping("/livres")
    Livre newlivre(@RequestBody Livre newLivre) {
    return repository.save(newLivre);
  	}

  @GetMapping("/livres/{id}")

  Livre one(@PathVariable Long id) {

    return repository.findById(id).orElseThrow(() -> new LivreNotFoundException(id));
  }

  @PutMapping("/livres/{id}")
  Livre replaceauteur(@RequestBody Livre newLivre, @PathVariable Long id) {

    return repository.findById(id) .map(livre -> {
      livre.setTitre(newLivre.getTitre());
      livre.setLangue(newLivre.getLangue());
      return repository.save(livre);
      })
      .orElseGet(() -> {
      newLivre.setId(id);
      return repository.save(newLivre);
    });
  }

  @DeleteMapping("/livres/{id}")
  void deleteLivre(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
