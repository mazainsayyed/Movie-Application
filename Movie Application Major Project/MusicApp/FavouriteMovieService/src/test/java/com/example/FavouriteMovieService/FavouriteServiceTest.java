package com.example.FavouriteMovieService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import com.example.FavouriteMovieService.FavouriteMovieService.Domain.Favourite;
import com.example.FavouriteMovieService.FavouriteMovieService.Exception.MovieAlreadyExistsException;
import com.example.FavouriteMovieService.FavouriteMovieService.Repository.FavouriteRepository;
import com.example.FavouriteMovieService.FavouriteMovieService.Service.FavouriteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class FavouriteServiceTest {

    @Mock
    private FavouriteRepository favouriteRepository;

    @InjectMocks
    private FavouriteServiceImpl favouriteService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveFavourite() throws MovieAlreadyExistsException {
        // Arrange
        Favourite favourite = new Favourite("12","","");

        when(favouriteRepository.save(favourite)).thenReturn(favourite);

        // Act
        Favourite savedFavourite = favouriteService.saveFavourite(favourite);

        // Assert
        assertNotNull(savedFavourite);
        assertEquals(favourite.getEmail(), savedFavourite.getEmail());
        assertEquals(favourite.getMovieName(), savedFavourite.getMovieName());
    }

@Test
    void testFindByMovieId() {
        // Arrange
        String movieId = "123";
        Favourite favourite = new Favourite("","","");
        favourite.setMovieId(movieId);

        when(favouriteRepository.findByMovieId(movieId)).thenReturn(favourite);

        // Act
        Favourite foundFavourite = favouriteService.findByMovieId(movieId);

        // Assert
        assertNotNull(foundFavourite);
        assertEquals(movieId, foundFavourite.getMovieId());
    }
}
