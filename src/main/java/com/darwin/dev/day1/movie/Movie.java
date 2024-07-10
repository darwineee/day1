package com.darwin.dev.day1.model;

public record Movie(
        int id,
        String name,
        int totalEps,
        int availableEps,
        boolean isLiked,
        byte star
) {
}
