package com.example.projetintrajsp.models;

import javax.servlet.http.HttpSession;

public class GestPanier {

    private static Panier panier;

    public static Panier getPanier(HttpSession session) {
            if(session.getAttribute("panier") != null) {
                panier = (Panier) session.getAttribute("panier");
            }
            return panier;
    }

    public static void setPanier(Panier panier, HttpSession session) {
            panier = new Panier();
            session.setAttribute("panier", panier);
    }
}
