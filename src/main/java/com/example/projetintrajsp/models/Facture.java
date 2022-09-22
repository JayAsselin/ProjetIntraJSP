package com.example.projetintrajsp.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Facture {
    private int numFacture;
    private String telephone;
    private String nomClient;
    private String adresse;
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
