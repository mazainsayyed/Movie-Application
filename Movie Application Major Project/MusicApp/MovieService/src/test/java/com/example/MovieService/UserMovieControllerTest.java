package com.example.MovieService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.example.MovieService.MovieService.Controller.UserMovieController;
import com.example.MovieService.MovieService.Domain.User;
import com.example.MovieService.MovieService.Service.UserMovieServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class UserMovieControllerTest {

    @Mock
    private UserMovieServiceImpl userMovieService;

    @InjectMocks
    private UserMovieController userMovieController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterUser() throws Exception {
        // Arrange
        User user = new User("", "","","","","");
        when(userMovieService.registerUser(user)).thenReturn(user);

        // Act
        ResponseEntity<?> responseEntity = userMovieController.registerUser(user);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(user, responseEntity.getBody());
    }
}
