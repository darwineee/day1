package com.darwin.dev.day1.mock;

import com.darwin.dev.day1.movie.Movie;

import java.util.List;

public class Data {
    public static void fill(List<Movie> movies) {
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
