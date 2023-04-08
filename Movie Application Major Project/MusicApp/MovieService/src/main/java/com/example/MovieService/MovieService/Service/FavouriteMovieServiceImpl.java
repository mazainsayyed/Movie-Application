package com.example.MovieService.MovieService.Service;

import com.example.MovieService.MovieService.Config.Producer;
import com.example.MovieService.MovieService.Domain.FavouriteMovie;
import com.example.MovieService.MovieService.Exception.MovieAlreadyExistsException;
import com.example.MovieService.MovieService.Exception.MovieNotFoundException;
import com.example.MovieService.MovieService.Repository.FavouriteMovieRepository;
import com.example.MovieService.rabbitMQ.Domain.FavouriteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FavouriteMovieServiceImpl implements FavouriteMovieService{

    private FavouriteMovieRepository favouriteMovieRepository;
    private Optional<FavouriteMovie> favMovie;
    @Autowired
    Producer producer;
    @Autowired
    public FavouriteMovieServiceImpl(FavouriteMovieRepository favouriteMovieRepository) {
        this.favouriteMovieRepository = favouriteMovieRepository;
    }

    @Override
    public FavouriteMovie registerFavourite(FavouriteMovie favouriteMovie) throws MovieAlreadyExistsException {
        FavouriteDTO favouriteDTO=new FavouriteDTO();
        favouriteDTO.setMovieId(favouriteMovie.getMovieId());
        favouriteDTO.setMovieName(favouriteMovie.getMovieName());
        favouriteDTO.setEmail(favouriteMovie.getEmail());
        if(favouriteMovieRepository.findById(favouriteMovie.getMovieId()).isPresent() )
        {
            favMovie=getFavouriteMovieByMovieId(favouriteMovie.getMovieId());
            if(favouriteMovie.getEmail().equals(favMovie.get().getEmail()))
            {
                throw new MovieAlreadyExistsException();
            }
            else
            {
                favouriteMovieRepository.save(favouriteMovie);
                System.out.println("saved user in mongo");
                producer.sendMessageToRabbitMq(favouriteDTO);
            }

        }
        else{
            favouriteMovieRepository.save(favouriteMovie);
            System.out.println("saved user in mongo");
            producer.sendMessageToRabbitMq(favouriteDTO);
        }
        return favouriteMovie;
    }

    @Override
    public boolean deleteMovieFromFavourites(String movieId, String email) throws MovieNotFoundException {
        favouriteMovieRepository.deleteByMovieIdAndEmail(movieId,email);
        return true;
    }

    public Optional<FavouriteMovie> getFavouriteMovieByMovieId(String movieId){
        return favouriteMovieRepository.findById(movieId);
    }
}
