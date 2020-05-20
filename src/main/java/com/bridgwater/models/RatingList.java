package com.bridgwater.models;

import java.util.ArrayList;
import java.util.List;

public class RatingList {
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
