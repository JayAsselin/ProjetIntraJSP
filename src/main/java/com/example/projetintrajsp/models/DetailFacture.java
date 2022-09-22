package com.example.projetintrajsp.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetailFacture {
    private int numFacture;
    private String isbn;
    private double prix;

    public DetailFacture(int numFacture, String isbn, double prix) {
        this.numFacture = numFacture;
        this.isbn = isbn;
        this.prix = prix;
    }

    public DetailFacture() {
    }
}
