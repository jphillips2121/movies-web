package com.movies.web.moviesweb.controller;

import com.movies.web.moviesweb.controllers.MainPageController;
import com.movies.web.moviesweb.model.AllMovieDetails;
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
public class MainPageControllerTests {

    private MockMvc mockMvc;

    @Mock
    private MovieService movieService;

    @InjectMocks
    private MainPageController mainPageController;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(mainPageController).build();
    }

    @Test
    @DisplayName("Main Page view success path")
    public void getRequestSuccess() throws Exception {
        AllMovieDetails allMovieDetails = new AllMovieDetails();
        TopCommenterDetails topCommenterDetails = new TopCommenterDetails();
        when(movieService.getAllMovieDetails()).thenReturn(allMovieDetails);
        when(movieService.getTopCommenter()).thenReturn(topCommenterDetails);

        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("mainPage"))
                .andExpect(model().attributeExists("topCommenter"));
    }

    @Test
    @DisplayName("Failure due to error on GET request for all movie details")
    public void getRequestFailureInGetAllMovieDetails() throws Exception {
        doThrow(IOException.class).when(movieService).getAllMovieDetails();

        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("error"));
    }

    @Test
    @DisplayName("Failure due to error on GET request for top commenter")
    public void getRequestFailureInGetTopCommenter() throws Exception {
        AllMovieDetails allMovieDetails = new AllMovieDetails();
        when(movieService.getAllMovieDetails()).thenReturn(allMovieDetails);
        doThrow(IOException.class).when(movieService).getTopCommenter();

        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("error"));
    }

}
