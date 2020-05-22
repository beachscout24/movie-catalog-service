package com.bridgwater.controllers;

import com.bridgwater.models.CatalogItem;
import com.bridgwater.models.RatingList;
import com.bridgwater.services.MovieInfoService;
import com.bridgwater.services.RatingInfoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/api")
public class MovieCatalogController {

    @Autowired
    private MovieInfoService movieInfoService;
    @Autowired
    private RatingInfoService ratingInfoService;

    @HystrixCommand(fallbackMethod = "getFallBackCatalog",
            threadPoolKey = "catalogPoolInfo",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10"),
            }
    )
    @GetMapping("/catalogs/{userId}")
    @ApiOperation(value = "Finds a list of cataloged movies",
            notes = "Provide an Id to retrieve up a catalog of movies with it;s ratings",
            response = List.class)
    public ResponseEntity<List<CatalogItem>> getCatalog(@PathVariable String userId) {
        log.info("get all rating by movie id");
        RatingList ratings = ratingInfoService.getRatings();
        return ResponseEntity.ok(ratings.getRatings().stream().map(movieInfoService::getCatalogItem).collect(Collectors.toList()));
    }

    public ResponseEntity<List<CatalogItem>> getFallBackCatalog(@PathVariable String userId) {
        return ResponseEntity.ok(Collections.singletonList(new CatalogItem("No Movie available", "Description not available", 0)));
    }
}
