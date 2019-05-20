package com.movies.web.moviesweb.controllers;

import com.movies.web.moviesweb.model.AllMovieDetails;
import com.movies.web.moviesweb.model.MovieDetails;
import com.movies.web.moviesweb.model.TopCommenterDetails;
import com.movies.web.moviesweb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import java.io.IOException;
import java.util.List;

@Controller
public class MainPageController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/")
    public String displayAllMovies(Model model) {
        AllMovieDetails allMovieDetails = new AllMovieDetails();
        TopCommenterDetails topCommenterDetails = new TopCommenterDetails();

        try {
            allMovieDetails = movieService.getAllMovieDetails();
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }

        try {
            topCommenterDetails = movieService.getTopCommenter();
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }

        List<MovieDetails> movies = allMovieDetails.getMovies();
        model.addAttribute("movies", movies);
        model.addAttribute("topCommenter", topCommenterDetails);

        return "mainPage";
    }

    @PostMapping(value = "/")
    public String mostLiked(Model model) {
        MovieDetails movieDetails = new MovieDetails();

        try {
            movieDetails = movieService.getMostLikedMovieDetails();
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }

        return UrlBasedViewResolver.REDIRECT_URL_PREFIX + "/movieId=" + movieDetails.getMovie_id();
    }
}
