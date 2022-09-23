package com.example.projetintrajsp.models;

import java.util.ArrayList;
import java.util.List;

public class LibrairieDataContext {
    private static final List<Livre> listeLivres = new ArrayList<>();

    private static final List<Facture> listeFactures = new ArrayList<>();

    private static final List<DetailFacture> listeDetailFactures = new ArrayList<>();

    public void ajouterLivre(Livre livre) {
        listeLivres.add(livre);
    }

    public List<Livre> getAllLivres() {
        return listeLivres;
    }

    public void ajouterFacture(Facture facture) {
        listeFactures.add(facture);
    }

    public void ajouterDetailFacture(DetailFacture detailFacture) {
        listeDetailFactures.add(detailFacture);
    }

    private int getNextNumFacture() {
        return listeFactures.size() + 1;
    }
}
