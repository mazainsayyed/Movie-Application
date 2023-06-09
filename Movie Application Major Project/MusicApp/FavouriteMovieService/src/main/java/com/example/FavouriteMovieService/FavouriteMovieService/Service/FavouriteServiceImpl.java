package com.example.FavouriteMovieService.FavouriteMovieService.Service;

import com.example.FavouriteMovieService.FavouriteMovieService.Domain.Favourite;
import com.example.FavouriteMovieService.FavouriteMovieService.Exception.MovieAlreadyExistsException;
import com.example.FavouriteMovieService.FavouriteMovieService.Exception.MovieNotFoundException;
import com.example.FavouriteMovieService.FavouriteMovieService.Repository.FavouriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteServiceImpl implements FavouriteService {
    private FavouriteRepository favouriteRepository;
    private Favourite favMovie;
    @Autowired
    public FavouriteServiceImpl(FavouriteRepository favouriteRepository) {
        this.favouriteRepository = favouriteRepository;
    }

    @Override
    public Favourite saveFavourite(Favourite favourite) throws MovieAlreadyExistsException {
        if(favouriteRepository.findById(favourite.getMovieId()).isPresent())
        {
            favMovie=findByMovieId(favourite.getMovieId());
            if(favourite.getEmail().equals(favMovie.getEmail()))
            {
                throw new MovieAlreadyExistsException();
            }
            System.out.println(favourite);
            return favouriteRepository.save(favourite);
        }
        System.out.println(favourite);
        return favouriteRepository.save(favourite);
    }

    @Override
    public Favourite findByMovieId(String movieId){
        System.out.println("movieId"+movieId);
        Favourite favourite = favouriteRepository.findByMovieId(movieId);
        System.out.println(favourite);
//        if(favourite == null)
//        {
//            throw new MovieAlreadyExistsException();
//        }

        return favourite;
    }

    @Override
    public List<Favourite> findMoviesByEmail(String email) {
        return favouriteRepository.findAllMoviesByEmail(email);
    }

    @Override
    public boolean deleteMovieFromFavourites(String movieId,String email) throws MovieNotFoundException {
//        if()

        favouriteRepository.deleteByMovieIdAndEmail(movieId,email);
        return true;
    }
}
