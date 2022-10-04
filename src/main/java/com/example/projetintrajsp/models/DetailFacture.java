package com.example.projetintrajsp.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class DetailFacture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;

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
