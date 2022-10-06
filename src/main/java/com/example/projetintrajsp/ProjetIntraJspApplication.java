package com.example.projetintrajsp;

import com.example.projetintrajsp.models.Livre;
import com.example.projetintrajsp.repositorys.LivreRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjetIntraJspApplication {

    @Autowired
    LivreRepository livreRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProjetIntraJspApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            Faker faker = new Faker();
            if (livreRepository.count() == 0) {
                for(int i = 0; i < 6; i++) {
                    Livre livre = new Livre();
                    livre.setAuteur(faker.book().author());
                    livre.setIsbn(faker.code().isbn13());
                    livre.setTitre(faker.book().title());
                    livre.setPrix(faker.number().randomDouble(2, 1, 100));
                    livre.setQuantite(faker.number().numberBetween(1, 100));
                    livre.setPhoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRv6ud_QTy0wevtfelvv8Te8bNEieBDVVv2tA&usqp=CAU");
                    livre.setResume(faker.lorem().paragraph());

                    livreRepository.save(livre);
                }
            }

        };
    }
}
