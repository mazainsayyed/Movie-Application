package com.example.MovieService.MovieService.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND,reason="User Not Found")
public class UserNotFoundException extends Exception{
}
