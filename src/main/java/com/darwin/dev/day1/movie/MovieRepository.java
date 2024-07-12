package com.darwin.dev.day1.movie;

import com.darwin.dev.day1.mock.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepository {
    private final List<Movie> movies = Collections.synchronizedList(new ArrayList<>());

    //Mock data
    MovieRepository() {
        Data.fill(movies);
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
                            type.map(t -> t == (mv.getTotalEps() > 1 ? 1 : 0)).orElse(true)
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
