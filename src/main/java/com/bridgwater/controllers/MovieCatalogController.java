package com.bridgwater.controllers;

import com.bridgwater.models.CatalogItem;
import com.bridgwater.models.Movie;
import com.bridgwater.models.RatingList;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/catalogs")
    public List<CatalogItem> getCatalog() {
        // get all rating by movie id
        ResponseEntity<String> result = restTemplate.getForEntity("http://ratings-service/ratings/", String.class);
        RatingList ratings = gson.fromJson(result.getBody(), RatingList.class);
        return ratings.getRatings().stream().map(rating -> {
            ResponseEntity<String> response = restTemplate.getForEntity("http://movie-service/movies/" + rating.getMovie(), String.class);
            Movie movie = gson.fromJson(response.getBody(), Movie.class);
            return new CatalogItem(movie.getId(), movie.getName(), movie.getDescription(), rating.getRating());
        }).collect(Collectors.toList());
    }
}
