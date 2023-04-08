package com.example.MovieService.MovieService.Controller;

import com.example.MovieService.MovieService.Domain.FavouriteMovie;
import com.example.MovieService.MovieService.Exception.MovieAlreadyExistsException;
import com.example.MovieService.MovieService.Exception.MovieNotFoundException;
import com.example.MovieService.MovieService.Service.FavouriteMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3/")
@CrossOrigin("http://localhost:4200")
public class FavouriteMovieController {

    private FavouriteMovieService favouriteMovieService;
    private ResponseEntity<?> responseEntity;

    @Autowired
    public FavouriteMovieController(FavouriteMovieService favouriteMovieService) {
        this.favouriteMovieService = favouriteMovieService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerFavourite(@RequestBody FavouriteMovie favouriteMovie) throws MovieAlreadyExistsException {
        try {
            responseEntity =  new ResponseEntity<>(favouriteMovieService.registerFavourite(favouriteMovie), HttpStatus.CREATED);
        }
        catch(MovieAlreadyExistsException e)
        {
            throw new MovieAlreadyExistsException();
        }
        return responseEntity;
    }

    @DeleteMapping("/deleteFavourite/{movieId}/{email}")
    public ResponseEntity<?> deleteMovieFromFavourites(@PathVariable String movieId,@PathVariable String email) throws MovieNotFoundException
    {
        try
        {
            responseEntity=new ResponseEntity<>(favouriteMovieService.deleteMovieFromFavourites(movieId,email),HttpStatus.OK);
        }
        catch(MovieNotFoundException e){
            throw new MovieNotFoundException();
        }
        catch (Exception e)
        {
            responseEntity=new ResponseEntity("Error !!! Try after sometime.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        System.out.println("message");
        System.out.println(responseEntity);
        return responseEntity;
    }
}

