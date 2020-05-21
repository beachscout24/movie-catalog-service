package com.bridgwater.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

@Component
@ApiModel("Catalog Item Details")
public class CatalogItem {

    public CatalogItem(String name, String description, Integer rating) {
        super();
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    public CatalogItem(Integer id, String name, String description, Integer rating) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    public CatalogItem() {
        super();
    }

    @ApiModelProperty("The id of the Catalog Item")
    private int id;
    @ApiModelProperty("Name of the Movie")
    private String name;
    @ApiModelProperty("Description of the Movie")
    private String description;
    @ApiModelProperty("Rating of the Movie")
    private int rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "CatalogItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                '}';
    }
}
