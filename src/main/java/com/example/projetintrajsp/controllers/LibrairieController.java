package com.example.projetintrajsp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibrairieController {

    /**
     * Affiche la page d'accueil
     * @return index.html
     */
    @GetMapping("/")
    public String accueil(){
            return "index";
    }
}
