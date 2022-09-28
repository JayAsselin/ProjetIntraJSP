package com.example.projetintrajsp.controllers;

import com.example.projetintrajsp.models.Admin;
import com.example.projetintrajsp.models.LibrairieDataContext;
import com.example.projetintrajsp.models.Livre;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AdminController {

    private static LibrairieDataContext dataContext;

    public AdminController() {
        dataContext = new LibrairieDataContext();
    }


    /**
     * Affiche la page de connection administrateur
     * @param session en cour
     * @return adminLogin.html
     */
    @GetMapping("/admin")
    public ModelAndView adminLogin(HttpSession session) {
        if (session.getAttribute("adminSession") != null) {
            return new ModelAndView("redirect:/adminPanel");
        }
        return new ModelAndView("views/adminLogin", "admin", new Admin());
    }

    /**
     * Verifie si l'information entrer dans le formulaire est valide et connecte l'admin au
     * dashboard  username = admin  password = password
     * @param session en cour
     * @param admin objet a valider
     * @param result affiche les messages d'erreurs
     * @return adminPanel.html
     */
    @PostMapping("/admin")
    public ModelAndView adminLogin(HttpSession session, @Valid @ModelAttribute Admin admin,
                                   BindingResult result) {

        if (result.hasErrors()) {
            return new ModelAndView("views/adminLogin");
        }
        session.setAttribute("adminSession", admin);
        return new ModelAndView("views/adminPanel");
    }

    /**
     * Affiche la page du dashboard administrateur
     * Retourne une page d'acces refuser si on essait de naviguer a la page et on est pas connecter
     * @param session en cour
     * @return adminPanel.html
     */
    @GetMapping("/adminPanel")
    public ModelAndView adminPanel(HttpSession session) {
        if(session.getAttribute("adminSession") == null) {
            return new ModelAndView("denied");
        }
        return new ModelAndView("views/adminPanel");
    }

    /**
     * Affiche la page d'ajout de livre et retourne une page d'acces refuser si on essait de
     * naviguer la page sans etre connecter
     * @param session en cour
     * @return ajouterLivre.html
     */
    @GetMapping("/adminPanel/ajouterLivre")
    public ModelAndView ajouterLivre(HttpSession session) {
        if(session.getAttribute("adminSession") == null) {
            return new ModelAndView("denied");
        }
        return new ModelAndView("views/ajouterLivre", "newLivre", new Livre());
    }

    /**
     * Verifie si l'information du livre est entrer correctement et retourne a la page adminPanel
     * @param session en cour
     * @param livre objet a valider
     * @param result affiche les messages d'erreurs
     * @return adminPanel.html
     */
    @PostMapping("/adminPanel/ajouterLivre")
    public ModelAndView ajouterLivre(HttpSession session,
                                     @Valid @ModelAttribute("newLivre") Livre livre,
                                     BindingResult result){
        if(session.getAttribute("adminSession") == null) {
            return new ModelAndView("denied");
        }
        if (result.hasErrors()) {
            return new ModelAndView("views/ajouterLivre");
        }
        dataContext.ajouterLivre(livre);
        return new ModelAndView("redirect:/adminPanel");
    }

    /**
     * Deconnecte l'utilisateur et redirige vers la vue adminLogin
     *
     * @param session en cour
     * @return adminLogin.html
     */
    @GetMapping("/adminPanel/logout")
    public ModelAndView logout(HttpSession session) {

        if (session.getAttribute("adminSession") != null) {
            session.removeAttribute("adminSession");
        }
        return new ModelAndView("redirect:/admin");
    }

}
