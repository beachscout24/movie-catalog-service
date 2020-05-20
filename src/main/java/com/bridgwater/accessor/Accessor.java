package com.bridgwater.accessor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Accessor {

    @Value("${rating.service.url}")
    public String ratingServiceUrl;

    @Value("${movie.service.url}")
    public String movieServiceUrl;

}
