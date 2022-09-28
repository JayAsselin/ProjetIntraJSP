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
    private Panier panier;

    public AchatController() {
        dataContext = new LibrairieDataContext();
    }

    @GetMapping("/listeLivres")
    public ModelAndView listeLivres(HttpSession session) {
        panier = GestPanier.getPanier(session);
        return new ModelAndView("views/listeLivres", "listeLivres", dataContext.getAllLivres());
    }

    @GetMapping("/listeLivres/acheter/{isbn}")
    public String acheterLivres(@PathVariable String isbn, HttpSession session){
        panier = GestPanier.getPanier(session);
        Livre livre = dataContext.findLivre(isbn);
        LivreAchete livreAcheter = new LivreAchete(livre.getIsbn(), livre.getTitre(), livre.getPrix());
        panier.ajouter(livreAcheter);
        GestPanier.setPanier(session, panier);
        return "redirect:/listeLivres";
    }

    @GetMapping("/listeLivres/info/{isbn}")
    public String showBook(@PathVariable String isbn, Model model){
        Livre livre = dataContext.findLivre(isbn);
        model.addAttribute("livre", livre);
        return "views/infoLivre";
    }
}
