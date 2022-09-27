package com.example.projetintrajsp.models;

import javax.servlet.http.HttpSession;

public class GestPanier {

    public static Panier getPanier(HttpSession session) {
        Panier panier;
            if(session.getAttribute("panier") != null) {
                panier = (Panier) session.getAttribute("panier");
            }
            else {
                panier = new Panier();
            }
            return panier;
    }

    public static void setPanier(HttpSession session, Panier panier) {
            session.setAttribute("panier", panier);
    }
}
