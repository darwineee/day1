package com.darwin.dev.day1.movie;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class MovieRepositoryTest {

    @InjectMocks
    private MovieRepository movieRepository;

    @Test
    public void testGetMovies_returnAll() {
        List<Movie> movies = movieRepository.getMovies(Optional.empty(), Optional.empty());
        assertEquals(movies.size(), 12);
    }

    @Test
    public void testGetMovies_returnFavorites() {
        List<Movie> movies = movieRepository.getMovies(Optional.of(true), Optional.empty());
        assertEquals(movies.size(), 5);
    }

    @Test
    public void testGetMovies_returnFavoritesByTypeFeature() {
        List<Movie> movies = movieRepository.getMovies(Optional.of(true), Optional.of(0));
        assertEquals(movies.size(), 3);
    }

    @Test
    public void testGetMovies_returnFavoritesByTypeSeries() {
        List<Movie> movies = movieRepository.getMovies(Optional.of(true), Optional.of(1));
        assertEquals(movies.size(), 2);
    }

    @Test
    public void testUpdateMovie() {
        //Arrange
        List<Movie> movies = movieRepository.getMovies(Optional.empty(), Optional.empty());
        if (movies.isEmpty()) assertTrue(true);

        //Act
        var movie = movies.get(0);
        var newMovie = new Movie(
                movie.getId(),
                movie.getName(),
                movie.getTotalEps(),
                movie.getAvailableEps(),
                !movie.isLiked(),
                0
        );
        movieRepository.updateMovie(movie.getId(), newMovie);
        var result = movieRepository.getMovies(Optional.empty(), Optional.empty()).get(0);

        //Assert
        assertEquals(movie.isLiked(), result.isLiked());
        assertEquals(movie.getStar(), result.getStar());
    }
}
