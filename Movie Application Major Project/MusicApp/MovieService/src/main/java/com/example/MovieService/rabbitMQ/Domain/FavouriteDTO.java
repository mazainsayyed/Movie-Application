package com.example.MovieService.rabbitMQ.Domain;

import lombok.*;


@Getter
@Setter
public class FavouriteDTO {
    private String movieId;
    private String movieName;
    private String email;

}
