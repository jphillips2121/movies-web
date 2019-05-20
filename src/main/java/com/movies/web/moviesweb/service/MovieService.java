package com.movies.web.moviesweb.service;

import com.movies.web.moviesweb.model.AllMovieDetails;
import com.movies.web.moviesweb.model.MovieDetails;
import com.movies.web.moviesweb.model.TopCommenterDetails;

import java.io.IOException;

/**
 * Interfaces with the movies-api
 */
public interface MovieService {

    AllMovieDetails getAllMovieDetails() throws IOException;

    MovieDetails getMovieDetails(String id) throws IOException;

    MovieDetails getMostLikedMovieDetails() throws IOException;

    TopCommenterDetails getTopCommenter() throws IOException;
}
