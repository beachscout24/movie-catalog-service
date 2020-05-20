package com.bridgwater.models;

import org.springframework.stereotype.Component;

@Component
public class CatalogItem {

    public CatalogItem(String name, String description, int rating) {
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    public CatalogItem() {
        super();
    }

    private int id;

    private String name;

    private String description;

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
