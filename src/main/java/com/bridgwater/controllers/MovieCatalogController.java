package com.bridgwater.controllers;

import com.bridgwater.models.CatalogItem;
import com.bridgwater.models.Movie;
import com.bridgwater.models.RatingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/catalogs")
    public @ResponseBody
    List<CatalogItem> getCatalog() {
        // get all rating by movie id
        RatingList result = restTemplate.getForObject("http://localhost:8200/ratings/", RatingList.class);
        System.out.println(result.getRatings());
        return result.getRatings().stream().map(rating -> {
            System.out.println("Rating: " + rating);
            Movie movie = restTemplate.getForObject("http://localhost:8000/movies/" + rating.getMovie(), Movie.class);
            System.out.println("Movie: " + movie);
            return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
        }).collect(Collectors.toList());
    }
}
