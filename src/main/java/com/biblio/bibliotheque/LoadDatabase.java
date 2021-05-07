package com.biblio.bibliotheque;


import com.biblio.bibliotheque.entity.Categorie;
import com.biblio.bibliotheque.repository.CategorieRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Configuration

public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDatabase(CategorieRepo repository) {
  
      return args -> {
        log.info("Preloading " + repository.save(new Categorie("Action")));
        log.info("Preloading " + repository.save(new Categorie("Police")));
      };
    }
    
}
