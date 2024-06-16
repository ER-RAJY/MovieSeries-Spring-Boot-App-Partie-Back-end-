package com.example.MovieserieV2.dto;

import lombok.Data;

@Data
public class UtilisateurDTO {
    private int id_Utilisateur;
    private String email;
    private String nom;
    private String password;

    public UtilisateurDTO(int idUtilisateur, String email, String nom, String password) {
    }
}
