package com.bridgwater.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

@Component
@ApiModel("Details of a Movie Object")
public class Movie {
    @ApiModelProperty("The id of a movie")
    private Integer id;
    @ApiModelProperty("The name of a movie")
    private String name;
    @ApiModelProperty("The description of a movie")
    private String description;
    @ApiModelProperty("The rating of a movie")
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
