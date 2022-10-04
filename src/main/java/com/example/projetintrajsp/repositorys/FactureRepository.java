package com.example.projetintrajsp.repositorys;

import com.example.projetintrajsp.models.Facture;
import org.springframework.data.repository.CrudRepository;

public interface FactureRepository extends CrudRepository<Facture, Integer> {
//    Facture getFactureByNumFacture(Integer numFacture);
}
