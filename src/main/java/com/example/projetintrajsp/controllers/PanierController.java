package com.example.projetintrajsp.controllers;

import com.example.projetintrajsp.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    private Panier panier;

    public PanierController() {
        dataContext = new LibrairieDataContext();
    }

    @GetMapping("/panier")
    public ModelAndView afficherPanier(HttpSession session){
        return new ModelAndView("views/afficherPanier", "panier", GestPanier.getPanier(session));
    }

    @GetMapping("/panier/supprimer/{isbn}")
    public String supprimerLivres(HttpSession session, @PathVariable String isbn) {
        panier = GestPanier.getPanier(session);
        panier.supprimer(isbn);
        GestPanier.setPanier(session, panier);
        return "redirect:/panier";
    }

    @GetMapping("/panier/vider")
    public String viderPanier(HttpSession session){
        panier = GestPanier.getPanier(session);
        panier.vider();
        return "redirect:/panier";
    }

    @GetMapping("/paiement")
    public ModelAndView paiement(Model model){
        model.addAttribute("facture", new Facture());
        return new ModelAndView("views/paiement");
    }

    @PostMapping("/paiement")
    public String paiement(@Valid @ModelAttribute Facture facture, BindingResult result, HttpSession session){
        if (result.hasErrors()){
            return "views/paiement";
        }
        panier = GestPanier.getPanier(session);
        facture.setNumFacture(facture.getNumFacture());
        facture.setNomClient(facture.getNomClient());
        facture.setAdresse(facture.getAdresse());
        facture.setTelephone(facture.getTelephone());
        facture.setEmail(facture.getEmail());
        facture.setMontantht(panier.getTotalCost());
        facture.setMttaxe(facture.getMontantht() * 0.15);
        facture.setMttotal(facture.getMontantht() + facture.getMttaxe());
        dataContext.ajouterFacture(facture);

        DetailFacture detail = new DetailFacture();
        for (LivreAchete livre : panier.getListe()){
            detail.setNumFacture(facture.getNumFacture());
            detail.setIsbn(livre.getIsbn());
            detail.setPrix(facture.getMttotal());
        }
        dataContext.ajouterDetailFacture(detail);
        return "views/confirmation";
    }
}
