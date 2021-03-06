package com.bridgwater.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@ApiModel("Details of a Rating Object")
public class Rating implements Serializable {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty("The id of a rating")
    private Integer id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty("The name of a movie")
    private String movie;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty("The rating of a movie")
    private Integer rating;

    public Rating() {
        super();
    }

    public Rating(Integer id, Integer rating) {
        super();
        this.id = id;
        this.rating = rating;
    }


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
