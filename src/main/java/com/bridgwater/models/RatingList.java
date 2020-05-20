package com.bridgwater.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RatingList implements Serializable {
    @JsonProperty("ratings")
    private List<Rating> ratings;

    public RatingList() {
        ratings = new ArrayList<>();
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
