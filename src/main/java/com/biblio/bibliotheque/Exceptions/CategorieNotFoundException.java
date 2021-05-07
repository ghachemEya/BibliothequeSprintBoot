package com.biblio.bibliotheque.Exceptions;

public class CategorieNotFoundException extends RuntimeException {

    public CategorieNotFoundException(Long id) {
      super("Could not find Categorie " + id);
    }
  }