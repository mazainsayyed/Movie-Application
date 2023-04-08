package com.example.MovieService.MovieService.Repository;

import com.example.MovieService.MovieService.Domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMovieRepository extends MongoRepository<User,String> {
}
