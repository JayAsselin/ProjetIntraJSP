package com.example.projetintrajsp.controllers;

import com.example.projetintrajsp.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class PanierController {

    private static LibrairieDataContext dataContext;
    private static GestPanier gestPanier;

    public PanierController() {
        dataContext = new LibrairieDataContext();
        gestPanier = new GestPanier();
    }

    @GetMapping("/panier")
    public ModelAndView afficherPanier(){
        return new ModelAndView("views/afficherPanier");
    }

    @GetMapping("/panier/supprimer/{isbn}")
    public String supprimerLivres(HttpSession session, @PathVariable String isbn) {
        Panier panier = gestPanier.getPanier(session);
        panier.supprimer(isbn);
        this.gestPanier.setPanier(session, panier);
        return "redirect:/panier";
    }

    @GetMapping("/paiement")
    public ModelAndView paiement(Model model){
        model.addAttribute("facture", new Facture());
        return new ModelAndView("views/paiement");
    }

    /**
     * Pas trop sur comment faire l'ajout du detailFacture correctement...
     * @param facture
     * @param detailFacture
     * @return
     */
    @PostMapping("/paiement")
    public String paiement(@Valid @ModelAttribute Facture facture,
                           @ModelAttribute DetailFacture detailFacture){
        this.dataContext.ajouterFacture(facture);
        this.dataContext.ajouterDetailFacture(detailFacture);
        return "views/confirmation";
    }
}
