package com.example.projetintrajsp.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivreAchete {
    private String isbn;
    private String titre;
    private double prix;

    public LivreAchete() {
    }

    public LivreAchete(String isbn, String titre, double prix) {
        this.isbn = isbn;
        this.titre = titre;
        this.prix = prix;
    }
}
