package com.example.projetintrajsp.repositorys;

import com.example.projetintrajsp.models.Livre;
import org.springframework.data.repository.CrudRepository;

public interface LivreRepository extends CrudRepository<Livre, Integer> {
    Livre getLivreByIsbn(String isbn);
}
