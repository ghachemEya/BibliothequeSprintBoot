package com.biblio.bibliotheque.repository;

//import java.util.List;

import com.biblio.bibliotheque.entity.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface AuteurRepo extends JpaRepository<Auteur, Long> {
    
    // @Query("select r from Auteur r where r.nationalite like %:nationalite")
    // List<Auteur> findByNationaliteAuteur (@Param("nationalite") String nationalite);

    
  
    // @Query("select r from Auteur r where r.last_name like %:lastName")
    // List<Auteur> findByLastNameAuteur (@Param("last_name") String lastName);

    
   

}
