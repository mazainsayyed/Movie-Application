package com.example.MovieService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import com.example.MovieService.MovieService.Domain.User;
import com.example.MovieService.MovieService.Repository.UserMovieRepository;
import com.example.MovieService.MovieService.Service.UserMovieServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UserMovieServiceTest {

    @Mock
    private UserMovieRepository userRepository;

    @InjectMocks
    private UserMovieServiceImpl userMovieService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterUser() throws Exception {
        // Arrange
        User user = new User("", "","","","","");

        when(userRepository.save(user)).thenReturn(user);

        // Act
        User registeredUser = userMovieService.registerUser(user);

        // Assert
        assertEquals(user, registeredUser);
    }
}