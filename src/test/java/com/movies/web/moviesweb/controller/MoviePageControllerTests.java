package com.movies.web.moviesweb.controller;

import com.movies.web.moviesweb.controllers.MainPageController;
import com.movies.web.moviesweb.controllers.MoviePageController;
import com.movies.web.moviesweb.model.AllMovieDetails;
import com.movies.web.moviesweb.model.MovieDetails;
import com.movies.web.moviesweb.model.TopCommenterDetails;
import com.movies.web.moviesweb.service.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class MoviePageControllerTests {

    private static final String MOVIE_ID = "1";
    private static final String MOVIE_PATH = "/movieId=" + MOVIE_ID;

    private MockMvc mockMvc;

    @Mock
    private MovieService movieService;

    @InjectMocks
    private MoviePageController moviePageController;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(moviePageController).build();
    }

    @Test
    @DisplayName("Movie Page view success path")
    public void getRequestSuccess() throws Exception {
        MovieDetails movieDetails = new MovieDetails();
        when(movieService.getMovieDetails(MOVIE_ID)).thenReturn(movieDetails);

        this.mockMvc.perform(get(MOVIE_PATH))
                .andExpect(status().isOk())
                .andExpect(view().name("moviePage"))
                .andExpect(model().attributeExists("movie"));
    }

    @Test
    @DisplayName("Failure due to error on GET request for movie details")
    public void getRequestFailureInGetAllMovieDetails() throws Exception {
        doThrow(IOException.class).when(movieService).getMovieDetails(MOVIE_ID);

        this.mockMvc.perform(get(MOVIE_PATH))
                .andExpect(status().isOk())
                .andExpect(view().name("error"));
    }
}