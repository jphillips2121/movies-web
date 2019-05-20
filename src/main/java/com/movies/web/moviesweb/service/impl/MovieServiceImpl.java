package com.movies.web.moviesweb.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movies.web.moviesweb.model.AllMovieDetails;
import com.movies.web.moviesweb.model.MovieDetails;
import com.movies.web.moviesweb.model.TopCommenterDetails;
import com.movies.web.moviesweb.service.MovieService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MovieServiceImpl implements MovieService {

    public AllMovieDetails getAllMovieDetails() throws IOException {
        AllMovieDetails movieDetails;

        // Set HTTPClient and Get Request
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://localhost:8081/movies");

        // Set Headers
        request.setHeader("accept", "application/json");
        request.setHeader("content-type", "application/json");

        HttpResponse response = httpClient.execute(request);
        ObjectMapper objectMapper = new ObjectMapper();
        movieDetails = objectMapper.readValue(response.getEntity().getContent(), AllMovieDetails.class);

        return movieDetails;
    }

    public MovieDetails getMovieDetails(String id) throws IOException {
        MovieDetails movieDetails;

        // Set HTTPClient and Get Request
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://localhost:8081/movies/" + id);

        // Set Headers
        request.setHeader("accept", "application/json");
        request.setHeader("content-type", "application/json");


        HttpResponse response = httpClient.execute(request);
        ObjectMapper objectMapper = new ObjectMapper();
        movieDetails = objectMapper.readValue(response.getEntity().getContent(), MovieDetails.class);

        return movieDetails;
    }

    public MovieDetails getMostLikedMovieDetails() throws IOException {
        MovieDetails movieDetails;

        // Set HTTPClient and Get Request
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://localhost:8081/likes");

        // Set Headers
        request.setHeader("accept", "application/json");
        request.setHeader("content-type", "application/json");

        HttpResponse response = httpClient.execute(request);
        ObjectMapper objectMapper = new ObjectMapper();
        movieDetails = objectMapper.readValue(response.getEntity().getContent(), MovieDetails.class);

        return movieDetails;
    }

    public TopCommenterDetails getTopCommenter() throws IOException {
        TopCommenterDetails topCommenterDetails;

        // Set HTTPClient and Get Request
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://localhost:8081/comments");

        // Set Headers
        request.setHeader("accept", "application/json");
        request.setHeader("content-type", "application/json");

        HttpResponse response = httpClient.execute(request);
        ObjectMapper objectMapper = new ObjectMapper();
        topCommenterDetails = objectMapper.readValue(response.getEntity().getContent(), TopCommenterDetails.class);

        return topCommenterDetails;
    }
}
