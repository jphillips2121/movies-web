package com.movies.web.moviesweb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentDetails {

    @JsonProperty("user")
    private String user;

    @JsonProperty("message")
    private String message;

    @JsonProperty("dateCreated")
    private String dateCreated;

    @JsonProperty("like")
    private Integer like;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }
}
