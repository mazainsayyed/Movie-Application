package com.example.MovieService.MovieService.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CHECKPOINT,reason="User Already Present")
public class UserAlreadyExistsException extends Exception{
}
