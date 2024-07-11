package com.darwin.dev.day1.movie;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepository {
    private final List<Movie> movies = Collections.synchronizedList(new ArrayList<>());

    MovieRepository() {
        synchronized (movies) {
            movies.add(new Movie(1, "Phim 1", 10, 10, true, 5));
            movies.add(new Movie(2, "Phim 2", 1, 1, true, 4));
            movies.add(new Movie(3, "Phim 3", 1, 1, false, 2));
            movies.add(new Movie(4, "Phim 4", 1, 1, true, 1));
            movies.add(new Movie(5, "Phim 5", 1, 1, false, 5));
            movies.add(new Movie(6, "Phim 6", 1, 1, true, 3));
            movies.add(new Movie(7, "Phim 7", 16, 1, false, 3));
            movies.add(new Movie(8, "Phim 8", 10, 4, true, 5));
            movies.add(new Movie(9, "Phim 9", 7, 7, false, 5));
            movies.add(new Movie(10, "Phim 10", 1, 1, false, 3));
            movies.add(new Movie(11, "Phim 11", 1, 1, false, 2));
            movies.add(new Movie(12, "Phim 12", 1, 1, false, 4));
        }
    }

    public List<Movie> getMovies(
            Optional<Boolean> liked,
            Optional<Integer> type
    ) {
        synchronized (movies) {
            return movies.stream()
                    .filter(mv ->
                            liked.map(l -> mv.isLiked() == l).orElse(true)
                    )
                    .filter(mv ->
                            type.map(t -> t == (mv.getAvailableEps() > 1 ? 1 : 0)).orElse(true)
                    )
                    .toList();
        }
    }

    public Movie updateMovie(int id, Movie movie) {
        synchronized (movies) {
            for (Movie mv : movies) {
                if (mv.getId() == id) {
                    mv.setLiked(movie.isLiked());
                    mv.setStar(movie.getStar());
                }
                return mv;
            }
            return null;
        }
    }
}
