package com.example.projetintrajsp.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class Facture {
    private int numFacture;
    @Pattern(regexp = "^\\(\\d{3}\\)\\s\\d{3}-\\d{4}$", message = "Le numéro de " +
            "telephone doit etre sous le format (XXX) XXX-XXXX")
    private String telephone;
    @Pattern(regexp = "^[A-zÉéèÈ\\-\\s]{2,40}$",message = "Le nom doit contenir entre 2 et 40 " +
            "charactères alphabétique.")
    private String nomClient;
    @Pattern(regexp = "^\\d{1,4}\\s([A-z]+\\s?)+$", message = "L'adresse doit etre sous le format" +
            " ex: 31 rue Dubuc")
    private String adresse;
    @Email(message = "Le courriel doit etre valide")
    private String email;
    private double montantht;
    private double mttaxe;
    private double mttotal;

    public Facture(int numFacture, String telephone, String nomClient, String adresse,
                   String email, double montantht, double mttaxe, double mttotal) {
        this.numFacture = numFacture;
        this.telephone = telephone;
        this.nomClient = nomClient;
        this.adresse = adresse;
        this.email = email;
        this.montantht = montantht;
        this.mttaxe = mttaxe;
        this.mttotal = mttotal;
    }

    public Facture() {
    }
}
