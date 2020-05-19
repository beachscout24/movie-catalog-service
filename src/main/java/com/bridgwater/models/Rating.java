package com.bridgwater.models;

import org.springframework.stereotype.Component;

@Component
public class Rating {

    public Rating() {
        super();
    }

    public Rating(Integer id, String movieId, Integer rating) {
        this.id = id;
        this.movieId = movieId;
        this.rating = rating;
    }

    private Integer id;
    private String movieId;
    private Integer rating;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
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
                ", movieId='" + movieId + '\'' +
                ", rating=" + rating +
                '}';
    }
}
