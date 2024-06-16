package com.example.MovieserieV2.service;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Movie;
    private String titre;
    private String description;
    private String dateDeSortie;
    private Integer duree;
    private String genre;
    private String realisateur;
    private String acteurs;
    private Double note;
    private String cover;
}
