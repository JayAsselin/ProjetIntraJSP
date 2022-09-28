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

    /**
     * Affiche la vue afficherPanier
     * @param session en cour
     * @return afficherPanier.html
     */
    @GetMapping("/panier")
    public ModelAndView afficherPanier(HttpSession session){
        return new ModelAndView("views/afficherPanier", "panier", GestPanier.getPanier(session));
    }

    /**
     * Prend l'isbn du livre et le supprime du panier
     * @param session en cour
     * @param isbn du livre
     * @return redirection vers afficherPanier
     */
    @GetMapping("/panier/supprimer/{isbn}")
    public String supprimerLivres(HttpSession session, @PathVariable String isbn) {
        panier = GestPanier.getPanier(session);
        panier.supprimer(isbn);
        GestPanier.setPanier(session, panier);
        return "redirect:/panier";
    }

    /**
     * Vide le panier au complet
     * @param session en cour
     * @return redirection vers afficherPanier
     */
    @GetMapping("/panier/vider")
    public String viderPanier(HttpSession session){
        panier = GestPanier.getPanier(session);
        panier.vider();
        return "redirect:/panier";
    }

    /**
     * Affiche la vue paiement
     * @param model pour ajouter l'attribut facture
     * @return paiement.html
     */
    @GetMapping("/paiement")
    public ModelAndView paiement(Model model){
        model.addAttribute("facture", new Facture());
        return new ModelAndView("views/paiement");
    }

    /**
     * Valide les entrer du formulaire et ajoute la facture a la listeFacture et chacun des
     * livres acheter dans la liste detailFacture
     * @param facture pour valider la facture
     * @param result pour faire l'affichage des messages d'erreurs
     * @param session en cour
     * @return confirmation.html
     */
    @PostMapping("/paiement")
    public ModelAndView paiement(@Valid @ModelAttribute Facture facture, BindingResult result,
                      HttpSession session){
        if (result.hasErrors()){
            return new ModelAndView("views/paiement");
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

        for (LivreAchete livre : panier.getListe()){
            DetailFacture detail = new DetailFacture();
            detail.setNumFacture(facture.getNumFacture());
            detail.setIsbn(livre.getIsbn());
            detail.setPrix(livre.getPrix());
            dataContext.ajouterDetailFacture(detail);
        }
        this.viderPanier(session);
        return new ModelAndView("views/confirmation");
    }
}
