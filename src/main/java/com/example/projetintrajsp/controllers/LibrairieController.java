package com.example.projetintrajsp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LibrairieController {

    @GetMapping("/")
    public String accueil(){
            return "index";
    }
}
