package com.bridgwater.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ApiModel("Details of a Rating List Object")
public class RatingList implements Serializable {
    @JsonProperty("ratings")
    @ApiModelProperty("The list of Rating Objects")
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
