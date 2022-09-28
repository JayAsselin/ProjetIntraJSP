package com.example.projetintrajsp.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Panier {
    private final List<LivreAchete> liste;

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

    /**
     * Passe a travers la liste pour trouver si l'isbn est present ou non
     * @param isbn passer en parametre
     * @return true ou false
     */
    public boolean isPresent(String isbn) {
        return liste.stream().anyMatch(i->i.getIsbn().equals(isbn));
    }

    /**
     * Passe a travers de la liste et fait la somme du prix de tout les livres
     * @return somme des prix
     */
    public double getTotalCost() {
       return liste.stream().mapToDouble(LivreAchete::getPrix).sum();
    }
}
