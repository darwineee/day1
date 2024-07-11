package com.darwin.dev.day1.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Movie {
    private int id;
    private String name;
    private int totalEps;
    private int availableEps;
    private boolean isLiked;
    private int star;
}

