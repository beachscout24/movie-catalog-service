package com.bridgwater.models;

import org.springframework.stereotype.Component;

@Component
public class Movie {
    private Integer id;
    private String name;
    private String description;
    private Integer rating;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Movie() {
        super();
    }


    public Movie(String title, String overview, Integer rating) {
        super();
        this.name = title;
        this.description = overview;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer movieId) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
