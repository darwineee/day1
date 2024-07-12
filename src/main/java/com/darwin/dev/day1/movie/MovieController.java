package com.darwin.dev.day1.movie;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepository movieRepository;

    @GetMapping
    public List<Movie> getMovies(
            @RequestParam("like") Optional<Boolean> like,
            @RequestParam("type") Optional<Integer> type
    ) {
        return movieRepository.getMovies(like, type);
    }

    @PutMapping(value = "/{id}")
    public Movie updateMovie(
            @PathVariable("id") int id,
            @RequestBody Movie movie
    ) {
        return movieRepository.updateMovie(id, movie);
    }
}
