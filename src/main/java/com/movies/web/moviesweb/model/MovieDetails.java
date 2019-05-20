package com.movies.web.moviesweb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MovieDetails {

    @JsonProperty("movie_id")
    private String movie_id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("producer")
    private String producer;

    @JsonProperty("available_in_3d")
    private Boolean available_in_3d;

    @JsonProperty("age_rating")
    private String age_rating;

    @JsonProperty("likes")
    private Integer likes;

    @JsonProperty("comments")
    private List<CommentDetails> comments;

    public String getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(String movie_id) {
        this.movie_id = movie_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Boolean getAvailable_in_3d() {
        return available_in_3d;
    }

    public void setAvailable_in_3d(Boolean available_in_3d) {
        this.available_in_3d = available_in_3d;
    }

    public String getAge_rating() {
        return age_rating;
    }

    public void setAge_rating(String age_rating) {
        this.age_rating = age_rating;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public List<CommentDetails> getComments() {
        return comments;
    }

    public void setComments(List<CommentDetails> comments) {
        this.comments = comments;
    }

}
