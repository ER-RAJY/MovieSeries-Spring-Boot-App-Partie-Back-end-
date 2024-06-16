package com.example.MovieserieV2.controller;


import com.movieseries.movieseries.dto.FavoriteDTO;
import com.movieseries.movieseries.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/favorite")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping
    public ResponseEntity<List<FavoriteDTO>> getAllMovies() {
        return ResponseEntity.ok(favoriteService.getAllFavorite());
    }


}
