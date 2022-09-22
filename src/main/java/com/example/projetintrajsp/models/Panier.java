package com.example.projetintrajsp.models;

import java.util.ArrayList;
import java.util.List;

public class Panier {
    private List<LivreAchete> liste;

    public Panier() {
        this.liste = new ArrayList<LivreAchete>();
    }

    public void ajouter(LivreAchete element) {
        liste.add(element);
    }

    public void supprimer(String isbn) {
        liste.removeIf(i->i.getIsbn().equals(isbn));
    }

    public List<LivreAchete> getListe() {
        return liste;
    }

    public void vider(){
        liste.clear();
    }

    public boolean isPresent(String isbn) {
        return liste.contains(isbn);
    }
}
