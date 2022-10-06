package com.example.projetintrajsp.models;

import com.example.projetintrajsp.repositorys.DetailFactureRepository;
import com.example.projetintrajsp.repositorys.FactureRepository;
import com.example.projetintrajsp.repositorys.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibrairieDataContext {

    @Autowired
    private LivreRepository livreRepository;
    @Autowired
    private FactureRepository factureRepository;
    @Autowired
    private DetailFactureRepository detailFactureRepository;

    public void ajouterLivre(Livre livre) {
        livreRepository.save(livre);
    }

    public Iterable<Livre> getAllLivres() {
            return livreRepository.findAll();
    }

    public void ajouterFacture(Facture facture) {
        factureRepository.save(facture);
    }

    public void ajouterDetailFacture(DetailFacture detailFacture) {
        detailFactureRepository.save(detailFacture);
    }

    public Livre findLivre(String isbn) {
        return livreRepository.getLivreByIsbn(isbn);
    }
}
