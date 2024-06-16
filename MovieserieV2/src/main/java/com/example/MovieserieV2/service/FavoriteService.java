package com.example.MovieserieV2.service;

import com.example.MovieserieV2.dao.FavoriteRepository;
import com.example.MovieserieV2.dto.FavoriteDTO;
import com.example.MovieserieV2.model.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FavoriteService {
    @Autowired
    private FavoriteRepository favoriteRepository;

    public List<FavoriteDTO> getAllFavorite() {
        return favoriteRepository.findAll().stream().map(favorite -> {
            FavoriteDTO dto = new FavoriteDTO();
            dto.setId_Favoris(favorite.getId_Favoris());
            if (favorite.getSeries() != null) {
                dto.setSeriesId(favorite.getSeries().getId_Series());
            }
            if (favorite.getMovie() != null) {
                dto.setMovieId(favorite.getMovie().getId_Movie());
            }
            return dto;
        }).collect(Collectors.toList());
    }

    public Optional<FavoriteDTO> getFavoriteById(Long id) {
        Optional<Favorite> favorite = favoriteRepository.findById(id);
        return favorite.map(f -> {
            FavoriteDTO dto = new FavoriteDTO();
            dto.setId_Favoris(f.getId_Favoris());
            if (f.getSeries() != null) {
                dto.setSeriesId(f.getSeries().getId_Series());
            }
            if (f.getMovie() != null) {
                dto.setMovieId(f.getMovie().getId_Movie());
            }
            return dto;
        });
    }

    public void deleteFavorite(Long id) {
        favoriteRepository.deleteById(id);
    }
}
