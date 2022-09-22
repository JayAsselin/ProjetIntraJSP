package com.example.projetintrajsp.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Livre {
    private String isbn;
    private String auteur;
    private String titre;
    private double prix;
    private int quantite;
    private String photo;
    private String resume;

    public Livre(String isbn, String auteur, String titre, double prix, int quantite,
                 String photo, String resume) {
        this.isbn = isbn;
        this.auteur = auteur;
        this.titre = titre;
        this.prix = prix;
        this.quantite = quantite;
        this.photo = photo;
        this.resume = resume;
    }

    public Livre() {
    }
}
