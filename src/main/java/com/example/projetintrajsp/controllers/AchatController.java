package com.example.projetintrajsp.controllers;

import com.example.projetintrajsp.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class AchatController {

    private static LibrairieDataContext dataContext;
    private static GestPanier gestPanier;
    private Panier panier;

    public AchatController() {
        dataContext = new LibrairieDataContext();
        gestPanier = new GestPanier();
    }

    @GetMapping("/listeLivres")
    public ModelAndView listeLivres(HttpSession session) {
        panier = gestPanier.getPanier(session);
        return new ModelAndView("views/listeLivres", "listeLivres", dataContext.getAllLivres());
    }

    @GetMapping("/listeLivres/acheter/{isbn}")
    public String acheterLivres(@PathVariable String isbn, HttpSession session){
        gestPanier.getPanier(session);
        LivreAchete livreAcheter = new LivreAchete();
        panier.ajouter(livreAcheter);
        gestPanier.setPanier(panier, session);
        return "redirect:/listeLivres";
    }

    @GetMapping("/listeLivres/infoLivre/{isbn}")
    public String showBook(@PathVariable String isbn, Model model){
        Livre livre =
                dataContext.getAllLivres().stream().filter(i ->i.getIsbn().equals(isbn)).findFirst().get();
        model.addAttribute("livre", livre);
        return "views/infoLivre";
    }
}
