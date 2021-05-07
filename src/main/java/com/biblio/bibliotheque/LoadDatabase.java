package com.biblio.bibliotheque;


import java.util.Date;
import com.biblio.bibliotheque.entity.Livre;
import com.biblio.bibliotheque.repository.LivreRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Configuration

public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDatabase(LivreRepo repository) {
      Date d = new Date(2021, 5, 7);
      return args -> {
        log.info("Preloading " + repository.save(new Livre("Action", "fr", d)));
      };
    }
    
}
