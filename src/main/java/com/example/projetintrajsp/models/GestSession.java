package com.example.projetintrajsp.models;

import javax.servlet.http.HttpSession;

public class GestSession {

    private static Panier panier;

    public static Panier getPanier(HttpSession session) {
        try {
            if(session.getAttribute("panier") != null){
                panier = (Panier)session.getAttribute("panier");
            }
            return panier;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void setPanier(Panier panier, HttpSession session) {
        try {
            panier = new Panier();
            session.setAttribute("panier", panier);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
