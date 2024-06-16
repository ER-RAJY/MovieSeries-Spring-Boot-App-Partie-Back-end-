// File: src/main/java/com/example/MovieserieV2/controller/UtilisateurController.java

package com.example.MovieserieV2.controller;

import com.example.MovieserieV2.dto.UtilisateurDTO;
import com.example.MovieserieV2.model.Utilisateur;
import com.example.MovieserieV2.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping
    public ResponseEntity<List<UtilisateurDTO>> getAllUsers() {
        List<UtilisateurDTO> users = utilisateurService.getAllUsers().stream()
                .map(user -> new UtilisateurDTO(user.getId_Utilisateur(), user.getEmail(), user.getNom(), user.getPassword()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDTO> getUserById(@PathVariable int id) {
        Optional<Utilisateur> user = utilisateurService.getUserById(id);
        return user.map(u -> ResponseEntity.ok(new UtilisateurDTO(u.getId_Utilisateur(), u.getEmail(), u.getNom(), u.getPassword())))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UtilisateurDTO> addUser(@RequestBody UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur = new Utilisateur(utilisateurDTO.getId_Utilisateur(), utilisateurDTO.getEmail(), utilisateurDTO.getNom(), utilisateurDTO.getPassword());
        Utilisateur savedUser = utilisateurService.saveUser(utilisateur);
        return ResponseEntity.ok(new UtilisateurDTO(savedUser.getId_Utilisateur(), savedUser.getEmail(), savedUser.getNom(), savedUser.getPassword()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        utilisateurService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
