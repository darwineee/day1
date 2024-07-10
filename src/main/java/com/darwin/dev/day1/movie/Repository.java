package com.darwin.dev.day1.data;

import com.darwin.dev.day1.model.Movie;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class Repository {
    private final List<Movie> movies = Collections.synchronizedList(new ArrayList<>());

    public List<Movie> getMovies() {
        synchronized (movies) {
            return movies;
        }
    }

    public List<Movie> getLikedMovie() {
        synchronized (movies) {
            return movies.stream()
                    .filter(Movie::isLiked)
                    .toList();
        }
    }

    public List<Movie> changeMovieLikedStatus(int movieId, boolean liked) {
        synchronized (movies) {
            return movies.stream()
                    .map(mv -> mv.id() == movieId ? setLikedMovie(mv, liked) : mv)
                    .toList();
        }
    }

    private Movie setLikedMovie(Movie movie, boolean liked) {
        return new Movie(
                movie.id(),
                movie.name(),
                movie.totalEps(),
                movie.availableEps(),
                liked,
                movie.star()
        );
    }
}
