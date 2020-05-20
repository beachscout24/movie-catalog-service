package com.bridgwater.controllers;

import com.bridgwater.accessor.Accessor;
import com.bridgwater.models.CatalogItem;
import com.bridgwater.models.Movie;
import com.bridgwater.models.RatingList;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Gson gson;
    @Autowired
    Accessor accessor;

    @GetMapping("/catalogs")
    public List<CatalogItem> getCatalog() {
        // get all rating by movie id
        ResponseEntity<String> result = restTemplate.getForEntity(accessor.ratingServiceUrl, String.class);
        RatingList ratings = gson.fromJson(result.getBody(), RatingList.class);
        return ratings.getRatings().stream().map(rating -> {
            ResponseEntity<String> response = restTemplate.getForEntity(accessor.movieServiceUrl + rating.getMovie(), String.class);
            Movie movie = gson.fromJson(response.getBody(), Movie.class);
            return new CatalogItem(movie.getId(), movie.getName(), movie.getDescription(), rating.getRating());
        }).collect(Collectors.toList());
    }

    @GetMapping("/catalogs/{movieId}")
    public CatalogItem getMovie(@PathVariable String movieId) {
        // get all rating by movie id
        Movie movie = restTemplate.getForObject(accessor.movieServiceUrl + movieId, Movie.class);
        return new CatalogItem(movie.getName(), movie.getDescription(), (movie.getRating() != null) ? movie.getRating() : 5);
    }
}
