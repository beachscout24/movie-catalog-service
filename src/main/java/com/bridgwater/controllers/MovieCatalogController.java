package com.bridgwater.controllers;

import com.bridgwater.models.CatalogItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @GetMapping("/{id}")
    public List<CatalogItem> getCatalog(@PathVariable("id") String userId) {
        return Collections.singletonList(new CatalogItem(1, "Transformers", "Movie", 4));
    }
}
