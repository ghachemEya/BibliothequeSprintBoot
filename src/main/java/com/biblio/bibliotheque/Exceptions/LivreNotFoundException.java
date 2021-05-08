package com.biblio.bibliotheque.Exceptions;

public class LivreNotFoundException extends RuntimeException {

    public LivreNotFoundException(Long id) {
        super("Could not find livre " + id);
      }
    
}
