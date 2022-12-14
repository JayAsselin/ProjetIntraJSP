package com.example.projetintrajsp.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class Livre {

    @Pattern(regexp="^\\d{13}$", message = "L'isbn d'un livre doit etre 13 chiffres")
    private String isbn;
    @Pattern(regexp="^[A-zÉéèÈ\\-\\s]{2,40}$",message = "Le nom d'auteur doit contenir entre 2 et" +
            " 40 charactères alphabétique.")
    private String auteur;
    @Pattern(regexp="^[A-zéÉèÈ\\d\\-\\s]{5,40}$", message ="Le titre doit contenir entre 5 et 40 " +
            "charactères alphanumériques.")
    private String titre;
    @DecimalMin(value = "0.10", message = "Le montant d'un livre doit etre minimum 0.10$.")
    @DecimalMax(value = "100.00", message = "Le montant d'un livre doit etre maximum 100.00$.")
    private double prix;
    @Min(value = 1, message = "La quantite doit etre minimum 1.")
    private int quantite;
    private String photo;
    @NotEmpty(message = "Vous devez entrer une description du livre.")
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
