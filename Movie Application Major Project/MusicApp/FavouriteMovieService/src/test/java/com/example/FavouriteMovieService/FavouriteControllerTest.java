package com.example.FavouriteMovieService;//package com.example.FavouriteMovieService;
//
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.example.FavouriteMovieService.FavouriteMovieService.Controller.FavouriteController;
import com.example.FavouriteMovieService.FavouriteMovieService.Domain.Favourite;
import com.example.FavouriteMovieService.FavouriteMovieService.Exception.MovieAlreadyExistsException;
import com.example.FavouriteMovieService.FavouriteMovieService.Service.FavouriteService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class FavouriteControllerTest {

    @Mock
    private FavouriteService favouriteService;

    @InjectMocks
    private FavouriteController favouriteController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveFavourite() throws Exception {
        // Arrange
        Favourite favourite = new Favourite("", "","");

        when(favouriteService.saveFavourite(favourite)).thenReturn(favourite);

        // Act
        ResponseEntity<?> responseEntity = favouriteController.saveFavourite(favourite);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(favourite, responseEntity.getBody());
    }

    @Test
    void testGetFavouriteMoviesByEmail() throws Exception {
        // Arrange
        String email = "";
        List<Favourite> favouriteList = new ArrayList<>();
        favouriteList.add(new Favourite(email, "",""));
        favouriteList.add(new Favourite(email, "",""));

        when(favouriteService.findMoviesByEmail(email)).thenReturn(favouriteList);

        // Act
        ResponseEntity<?> responseEntity = favouriteController.getFavouriteMoviesByEmail(email);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(favouriteList, responseEntity.getBody());
    }
}






//public class FavouriteControllerTest {
//
//    @Mock
//    private FavouriteService favouriteService;
//
//    private FavouriteController favouriteController;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//        favouriteController = new FavouriteController(favouriteService);
//    }
//
//    @Test
//    public void testSaveFavourite() throws MovieAlreadyExistsException {
//        Favourite favourite = new Favourite("", "", "");
//        when(favouriteService.saveFavourite(favourite)).thenReturn(favourite);
//
//        ResponseEntity<?> response = favouriteController.saveFavourite(favourite);
//
//        verify(favouriteService, times(1)).saveFavourite(favourite);
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//        assertEquals(favourite, response.getBody());
//    }
//    @Test
//    void testGetFavouriteMoviesByEmail() throws Exception {
//        // Arrange
//        String email = "Zainsayyed@gmail.com";
//        List<String> movies = Arrays.asList("Movie1", "Movie2");
//        when(favouriteService.findMoviesByEmail(email)).thenReturn(movies);
//
//        // Act
//        ResponseEntity<?> responseEntity = favouriteController.getFavouriteMoviesByEmail(email);
//
//        // Assert
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals(movies, responseEntity.getBody());
//    }








