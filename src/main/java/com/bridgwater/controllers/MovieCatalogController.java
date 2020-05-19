package com.bridgwater.controllers;

import com.bridgwater.models.CatalogItem;
import com.bridgwater.models.Movie;
import com.bridgwater.models.Rating;
import com.bridgwater.repository.CatalogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalogs")
@Slf4j
public class MovieCatalogController {

    private RestTemplate restTemplate;
    @Autowired
    private CatalogRepository catalogRepository;

    @GetMapping("/{id}")
    public List<CatalogItem> getCatalog(@PathVariable("id") String userId) {
        Movie movie = null;
        // get all rating by movie id
        Rating rating = restTemplate.getForObject("localhost:8200/ratings/" + userId, Rating.class);
        // for each movieId call movie service to get details
        if (rating != null)
            movie = restTemplate.getForObject("localhost:8000/movies/" + rating.getId(), Movie.class);

        // put all together for return
        return Collections.singletonList(new CatalogItem(1, "Transformers", "Movie", 4));
    }
}
