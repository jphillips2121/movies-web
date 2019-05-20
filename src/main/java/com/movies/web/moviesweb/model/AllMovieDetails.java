package com.movies.web.moviesweb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AllMovieDetails {

    @JsonProperty("movies")
    private List<MovieDetails> movies;

    public List<MovieDetails> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDetails> movies) {
        this.movies = movies;
    }
}
