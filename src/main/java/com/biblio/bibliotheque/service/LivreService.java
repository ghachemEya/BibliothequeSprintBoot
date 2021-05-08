package com.biblio.bibliotheque.service;

import java.util.List;

import com.biblio.bibliotheque.entity.Livre;
import com.biblio.bibliotheque.repository.LivreRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivreService {
    @Autowired
    LivreRepo livreRepositoty;


    public Livre saveLivre (Livre p){
        return livreRepositoty.save(p);
    }


	public void  deleteLivre(Livre p){
        livreRepositoty.delete(p);
    }



	public void deleteLivreById(Long id){
        livreRepositoty.deleteById(id);
    }


	public Livre getLivre(Long id){
        return livreRepositoty.findById(id).get();
    }



	public List<Livre> getAllLivres(){
        return livreRepositoty.findAll();
    }
}
