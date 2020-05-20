package com.bridgwater.models;

import org.springframework.stereotype.Component;

@Component
public class Rating {
    private Integer id;
    private String movie;
    private Integer rating;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movieId) {
        this.movie = movie;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", movie='" + movie + '\'' +
                ", rating=" + rating +
                '}';
    }
}
