package com.biblio.bibliotheque.repository;

import com.biblio.bibliotheque.entity.Livre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreRepo extends JpaRepository<Livre, Long>{

    
    // @Query("select l from livre l where l.langue like %:langue")
    // List<Livre> findByLangueLivre (@Param("langue") String languee);
}
