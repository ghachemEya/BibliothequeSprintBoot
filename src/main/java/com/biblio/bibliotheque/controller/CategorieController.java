package com.biblio.bibliotheque.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CategorieController {
    
    @RequestMapping("/")
    public String Home(){
        return "hello world!";
    }
}
