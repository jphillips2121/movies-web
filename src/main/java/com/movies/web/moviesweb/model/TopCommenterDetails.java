package com.movies.web.moviesweb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TopCommenterDetails {

    @JsonProperty("user")
    private String user;

    @JsonProperty("comments")
    private Integer comments;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getComments() {
        return comments;
    }

    public void setCommenst(Integer comment) {
        this.comments = comment;
    }
}
