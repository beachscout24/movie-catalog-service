package com.bridgwater.controllers;

import com.bridgwater.accessor.Accessor;
import com.bridgwater.models.CatalogItem;
import com.bridgwater.models.RatingList;
import com.bridgwater.services.MovieInfoService;
import com.bridgwater.services.RatingInfoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class MovieCatalogController {

    @Autowired
    private MovieInfoService movieInfoService;
    @Autowired
    private RatingInfoService ratingInfoService;
    @Autowired
    private Accessor accessor;

    @HystrixCommand(fallbackMethod = "getFallBackCatalog",
            threadPoolKey = "catalogPoolInfo",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10"),
            }
    )
    @GetMapping("/catalogs/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId) {
        log.info("get all rating by movie id");
        RatingList ratings = ratingInfoService.getRatings();
        return ratings.getRatings().stream().map(movieInfoService::getCatalogItem).collect(Collectors.toList());
    }

    public List<CatalogItem> getFallBackCatalog(@PathVariable String userId) {
        return Collections.singletonList(new CatalogItem("No Movie available", "Description not available", 0));
    }
}
