package com.biblio.bibliotheque.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.biblio.bibliotheque.entity.Categorie;
import com.biblio.bibliotheque.repository.CategorieRepo;
import org.springframework.beans.factory.annotation.Autowired;



@Service
public class CategorieService {
    @Autowired
    CategorieRepo categorieRepositoty;




    public Categorie saveCategorie (Categorie p){
        return categorieRepositoty.save(p);
    }


	public void  deleteCategorie(Categorie p){
        categorieRepositoty.delete(p);
    }



	public void deleteCategorieById(Long id){
        categorieRepositoty.deleteById(id);
    }


	public Categorie getCategorie(Long id){
        return categorieRepositoty.findById(id).get();
    }



	public List<Categorie> getAllAuteurs(){
        return categorieRepositoty.findAll();
    }
}
