package com.example.MovieService.MovieService.Service;

import com.example.MovieService.MovieService.Domain.FavouriteMovie;
import com.example.MovieService.MovieService.Exception.MovieAlreadyExistsException;
import com.example.MovieService.MovieService.Exception.MovieNotFoundException;

public interface FavouriteMovieService {
    FavouriteMovie registerFavourite(FavouriteMovie favouriteMovie) throws MovieAlreadyExistsException;
    boolean deleteMovieFromFavourites(String movieId,String email) throws MovieNotFoundException;
}
