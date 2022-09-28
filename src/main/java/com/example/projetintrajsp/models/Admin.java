package com.example.projetintrajsp.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
public class Admin {

    @Pattern(regexp = "^(admin)$", message = "Nom d'utilisateur invalide")
    private String username;
    @Pattern(regexp = "^(password)$", message = "Mot de passe invalide")
    private String password;

    public Admin() {
    }
}
