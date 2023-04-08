package com.example.MovieService.MovieService.Controller;

import com.example.MovieService.MovieService.Domain.User;
import com.example.MovieService.MovieService.Exception.UserAlreadyExistsException;
import com.example.MovieService.MovieService.Exception.UserNotFoundException;
import com.example.MovieService.MovieService.Service.UserMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v2")
@CrossOrigin("http://localhost:4200")
public class UserMovieController {
    private UserMovieService userMovieService;
    private ResponseEntity<?> responseEntity;

    @Autowired
    public UserMovieController(UserMovieService userMovieService) {
        this.userMovieService = userMovieService;
//        this.responseEntity = responseEntity;
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyExistsException {
        try {
            responseEntity =  new ResponseEntity<>(userMovieService.registerUser(user), HttpStatus.CREATED);
        }
        catch(UserAlreadyExistsException e)
        {
            throw new UserAlreadyExistsException();
        }
        return responseEntity;
    }
    @GetMapping("/registers/{email}")
    public ResponseEntity<?> getUserbyEmail(@PathVariable String email) throws UserNotFoundException {
        try{
            responseEntity = new ResponseEntity<>(userMovieService.getUserByEmail(email), HttpStatus.OK);
        }catch(UserNotFoundException e)
        {
            throw new UserNotFoundException();
        }
        return responseEntity;
    }
}
