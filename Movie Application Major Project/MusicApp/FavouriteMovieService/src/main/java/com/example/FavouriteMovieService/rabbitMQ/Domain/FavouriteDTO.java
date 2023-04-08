package com.example.FavouriteMovieService.rabbitMQ.Domain;

import jdk.jfr.Name;
import lombok.*;


@Getter
@Setter
public class FavouriteDTO {
    private String movieId;
    private String movieName;
    private String email;
}
