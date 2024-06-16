package com.example.MovieserieV2.sevice;

import com.example.MovieserieV2.model.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface UtilisateurService {
    List<Utilisateur> getAllUsers();
    Optional<Utilisateur> getUserById(Long id);
    Utilisateur saveUser(Utilisateur utilisateur);
    void deleteUserById(Long id);
}
