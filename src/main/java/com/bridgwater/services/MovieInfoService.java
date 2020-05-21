package com.bridgwater.services;

import com.bridgwater.accessor.Accessor;
import com.bridgwater.models.CatalogItem;
import com.bridgwater.models.Movie;
import com.bridgwater.models.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class MovieInfoService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Accessor accessor;

    @HystrixCommand(fallbackMethod = "getFallBackCatalogItem")
    public CatalogItem getCatalogItem(Rating rating) {
        log.info("Calling external api themoviedb.org with: " + accessor.movieServiceUrl + rating.getId());
        Movie movie = restTemplate.getForObject(accessor.movieServiceUrl + rating.getId(), Movie.class);
        log.info("Movie: " + movie);
        return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
    }

    public CatalogItem getFallBackCatalogItem(Rating rating) {
        return new CatalogItem("No Movie Available", "No Description available", 0);
    }
}
