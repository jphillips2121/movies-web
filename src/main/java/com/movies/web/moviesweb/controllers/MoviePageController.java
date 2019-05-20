package com.movies.web.moviesweb.controllers;

import com.movies.web.moviesweb.model.CommentDetails;
import com.movies.web.moviesweb.model.MovieDetails;
import com.movies.web.moviesweb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class MoviePageController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/movieId={movieId}")
    public String displayMovie(@PathVariable String movieId, Model model) {
        MovieDetails movieDetails = new MovieDetails();

        try {
            movieDetails = movieService.getMovieDetails(movieId);
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }

        List<CommentDetails> comments = movieDetails.getComments();

        model.addAttribute("movie", movieDetails);
        model.addAttribute("comments", comments);

        return "moviePage";
    }
}
