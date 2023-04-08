package com.example.MovieService.MovieService.Service;

import com.example.MovieService.MovieService.Domain.User;
import com.example.MovieService.MovieService.Exception.UserAlreadyExistsException;
import com.example.MovieService.MovieService.Exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserMovieService {
    User registerUser(User user) throws UserAlreadyExistsException;
    Optional<User> getUserByEmail(String email) throws UserNotFoundException;
}
