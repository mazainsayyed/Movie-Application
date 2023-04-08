package com.example.FavouriteMovieService.FavouriteMovieService.Domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Favourite {
    @Id
    private String movieId;
    private String movieName;
    private String email;

}
