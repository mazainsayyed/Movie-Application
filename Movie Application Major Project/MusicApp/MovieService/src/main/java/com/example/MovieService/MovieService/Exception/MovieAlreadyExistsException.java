package com.example.MovieService.MovieService.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT,reason="Movie already present")
public class MovieAlreadyExistsException extends Exception{
}
