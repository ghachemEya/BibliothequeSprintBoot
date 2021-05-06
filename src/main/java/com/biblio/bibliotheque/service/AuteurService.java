package com.biblio.bibliotheque.service;

import java.util.List;

import com.biblio.bibliotheque.entity.Auteur;
import com.biblio.bibliotheque.repository.AuteurRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuteurService {

    @Autowired
    AuteurRepo auteurRepositoty;




    public Auteur saveAuteur (Auteur p){
        return auteurRepositoty.save(p);
    }


	public void  deleteAuteur(Auteur p){
        auteurRepositoty.delete(p);
    }



	public void deleteAuteurById(Long id){
        auteurRepositoty.deleteById(id);
    }


	public Auteur getAuteur(Long id){
        return auteurRepositoty.findById(id).get();
    }



	public List<Auteur> getAllAuteurs(){
        return auteurRepositoty.findAll();
    }
}
