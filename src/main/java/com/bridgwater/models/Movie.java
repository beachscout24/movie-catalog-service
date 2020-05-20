package com.bridgwater.models;

import org.springframework.stereotype.Component;

@Component
public class Movie {

    private Integer movieId;
    private String name;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Movie() {
        super();
    }

    public Movie(int i, String sneakers) {
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
