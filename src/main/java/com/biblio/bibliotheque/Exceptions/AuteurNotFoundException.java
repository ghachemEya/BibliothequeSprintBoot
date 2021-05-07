package com.biblio.bibliotheque.Exceptions;

public class AuteurNotFoundException extends RuntimeException {

    public AuteurNotFoundException(Long id) {
      super("Could not find auteur " + id);
    }
  }
