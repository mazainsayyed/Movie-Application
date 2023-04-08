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
public class User {
    @Id
    private String email;
    private String password;
    private String userName;
    private String phoneNumber;
    private String gender;
    private String profilePicture;


}
