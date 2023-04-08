package com.example.FavouriteMovieService.FavouriteMovieService.Service;

import com.example.FavouriteMovieService.FavouriteMovieService.Domain.Favourite;
import com.example.FavouriteMovieService.FavouriteMovieService.Exception.MovieAlreadyExistsException;
import com.example.FavouriteMovieService.FavouriteMovieService.Exception.MovieNotFoundException;

import java.util.List;

public interface FavouriteService {
    Favourite saveFavourite(Favourite favourite) throws MovieAlreadyExistsException;
    Favourite findByMovieId(String movieId);
    List<Favourite> findMoviesByEmail(String email);
    boolean deleteMovieFromFavourites(String movieId,String email) throws MovieNotFoundException;


}
