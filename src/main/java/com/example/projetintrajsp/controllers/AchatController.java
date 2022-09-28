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

    /**
     * Affiche la liste de livre a acheter
     * @param session en cour
     * @return listeLivres.html
     */
    @GetMapping("/listeLivres")
    public ModelAndView listeLivres(HttpSession session) {
        panier = GestPanier.getPanier(session);
        return new ModelAndView("views/listeLivres", "listeLivres", dataContext.getAllLivres());
    }

    /**
     * Ajoute un livre au panier a l'aide de l'isbn
     * @param isbn du livre passer dans l'url
     * @param session en cour
     * @return redirection ver listeLivres.html
     */
    @GetMapping("/listeLivres/acheter/{isbn}")
    public String acheterLivres(@PathVariable String isbn, HttpSession session){
        panier = GestPanier.getPanier(session);
        Livre livre = dataContext.findLivre(isbn);
        LivreAchete livreAcheter = new LivreAchete(livre.getIsbn(), livre.getTitre(), livre.getPrix());
        panier.ajouter(livreAcheter);
        GestPanier.setPanier(session, panier);
        return "redirect:/listeLivres";
    }

    /**
     * Affiche la vue infoLivre pour voir le resume du livre
     * @param isbn du livre passer dans l'url
     * @return infoLivre.html
     */
    @GetMapping("/listeLivres/info/{isbn}")
    public ModelAndView showBook(@PathVariable String isbn){
        Livre livre = dataContext.findLivre(isbn);
        return new ModelAndView("views/infoLivre", "livre", livre);
    }
}
