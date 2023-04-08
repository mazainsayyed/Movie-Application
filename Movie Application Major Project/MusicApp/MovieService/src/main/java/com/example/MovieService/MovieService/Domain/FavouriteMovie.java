package com.example.MovieService.MovieService.Domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class FavouriteMovie {
    @Id
    private String movieId;
    private String movieName;
    private String email;
}
