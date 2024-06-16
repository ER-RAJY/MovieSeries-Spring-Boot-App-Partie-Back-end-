package com.example.MovieserieV2.service;


import com.example.MovieserieV2.dao.UtilisateurRepository;
import com.example.MovieserieV2.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> getAllUsers() {
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> getUserById(Long id) {
        return utilisateurRepository.findById(id);
    }

    public Utilisateur saveUser(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public void deleteUserById(Long id) {
        utilisateurRepository.deleteById(id);
    }
}
