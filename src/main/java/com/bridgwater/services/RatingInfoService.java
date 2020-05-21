package com.bridgwater.services;

import com.bridgwater.accessor.Accessor;
import com.bridgwater.models.Rating;
import com.bridgwater.models.RatingList;
import com.google.gson.Gson;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class RatingInfoService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Gson gson;
    @Autowired
    private Accessor accessor;

    @HystrixCommand(fallbackMethod = "getFallBackRating")
    public RatingList getRatings() {
        // get all rating by movie id
        ResponseEntity<String> result = restTemplate.getForEntity(accessor.ratingServiceUrl, String.class);
        return gson.fromJson(result.getBody(), RatingList.class);
    }

    public RatingList getFallBackRating() {
        RatingList ratingList = new RatingList();
        ratingList.setRatings(Collections.singletonList(new Rating(0, 0)));
        return ratingList;
    }
}
